/*
 * Copyright © ShiwaForce.com Zrt. 2012 - 2019.
 * All rights reserved.
 */
package com.matetoser.adventofcode.daytwo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author matetoser
 * @since 2019. 12. 10.
 */
@Service
public class ProgramAlarm {

	private final static int FINISH = 99;
	private final static int ADD = 1;
	private final static int MULTIPLE = 2;

	public Integer restoreGravity(){
		int[] input = getInput();
		modifyInput(input);
		return input[0];
	}

	private void modifyInput(int[] input){
		for(int i = 0; i < input.length; i = i + 4){
			if(input[i] == FINISH){
				break;
			} else if(input[i] == ADD){
				input[input[i+3]] = input[input[i+1]] + input[input[i+2]];
			} else if(input[i] == MULTIPLE){
				input[input[i+3]] = input[input[i+1]] * input[input[i+2]];
			} else {
				System.out.println("Unknown opcode, something went wrong!");
			}
		}
	}

	private int[] getInput() {
		try {
			File inputFile = new ClassPathResource("daytwo/input.txt").getFile();
			List<String> lines = Files.readAllLines(inputFile.toPath());
			StringBuilder sb = new StringBuilder();
			for(String line : lines){
				sb.append(line);
			}
			String[] input = sb.toString().split(",");
			return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new int[0];
	}

}
