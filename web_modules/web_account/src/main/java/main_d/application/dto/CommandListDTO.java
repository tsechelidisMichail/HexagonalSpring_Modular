package main_d.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class CommandListDTO {

	/*
		Must reflect the Controller pathing, due to @RequiredArgs - from top to bottom id->balance.
	 */

	private int amount;
}
