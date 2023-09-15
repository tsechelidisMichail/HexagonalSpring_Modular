REM must be used after a .jar is produced as native (mvn package -Pnative) - won't work for regular .jar (mvn package)

@echo off

REM Get metadata of produced native .jar
setlocal enabledelayedexpansion
set "parentDir=.."
for /f "usebackq tokens=*" %%a in (`%parentDir%\mvnw.cmd help:evaluate -Dexpression^=project.name -q -DforceStdout`) do (
    set "name=%%a"
)
for /f "usebackq tokens=*" %%a in (`%parentDir%\mvnw.cmd help:evaluate -Dexpression^=project.version -q -DforceStdout`) do (
    set "version=%%a"
)

set "jarName=%name%-%version%"

REM extract .jar (spring boot structured) into native folder( native-image can't parse spring-boot jar https://docs.spring.io/spring-native/docs/0.12.x/reference/htmlsingle/#_with_code_native_image_code )
if exist "target\native" (
    rmdir /s /q target\native
)
mkdir target\native
cd target\native
jar -xvf ..\%jarName%.jar
xcopy /E /I META-INF BOOT-INF\classes

setlocal enabledelayedexpansion
set "classpath=BOOT-INF\classes"

for /r "BOOT-INF\lib" %%i in (*.jar) do (
    set "classpath=!classpath!;%%i"
)

REM use the extracted files
native-image -H:IncludeResources=".*.properties$" -H:Name=%jarName% -cp !classpath! main.Main