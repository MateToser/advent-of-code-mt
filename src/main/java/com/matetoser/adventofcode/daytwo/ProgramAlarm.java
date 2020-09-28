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

	public Integer gravityAssist(){
		int goal = 19690720;
		int current = 0;
		int noun = 0;
		int verb = 0;
		for(int i = 0; i <= 99; i++){
			noun = i;
			for(int j = 0; j <= 99; j++){
				int[] input = getInput();
				verb = j;
				input[1] = noun;
				input[2] = verb;
				modifyInput(input);
				current = input[0];
				if(goal == current){
					return 100 * noun + verb;
				}
			}
		}
		return 100 * noun + verb;
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
