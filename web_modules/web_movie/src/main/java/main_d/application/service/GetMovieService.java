package main_d.application.service;

import lombok.RequiredArgsConstructor;
import main_d.Account;
import main_d.application.dto.CommandMovieDTO;
import main_d.application.port.in.LoadMovieUseCase;
import main_d.application.port.out.queries.LoadAccount;
import main_d.application.port.out.queries.LoadMovie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@EnableTransactionManagement
@Service
class GetMovieService implements LoadMovieUseCase {
    private final LoadAccount loadAccount;
    private final LoadMovie loadMovie;

    @Transactional(value = "chainedTransactionManager")
    @Override
    public String loadMovie(CommandMovieDTO commandMovieDTO){

        int id = commandMovieDTO.getId();
        String movieName = commandMovieDTO.getMovieName();
        Account account = loadAccount.loadAccount(id);

        String result="";
        if(account!=null){
            result = loadMovie.loadMovie(movieName).getName();
        }

        return result;
    }

    /*TODO:**********************************************************************
       At some point ChainedTransactionManager will be deprecated
       + it doesn't ensure all useCases for a transaction's scenario
       I will need to introduce Atomikos and configure a global transaction manager
       ***********************************************************************/
    @Configuration
    public class MultipleDatasourceTransactionManagerConfig {

        @Bean(name = "chainedTransactionManager")
        public ChainedTransactionManager chainedTransactionManager(
                @Qualifier("primaryTransactionManager")
                PlatformTransactionManager primaryTransactionManager,
                @Qualifier("secondaryTransactionManager")
                PlatformTransactionManager secondaryTransactionManager ){
            return new ChainedTransactionManager(primaryTransactionManager,secondaryTransactionManager);
        }

    }
}
