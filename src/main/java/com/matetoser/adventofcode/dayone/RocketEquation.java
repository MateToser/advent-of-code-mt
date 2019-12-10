/*
 * Copyright © ShiwaForce.com Zrt. 2012 - 2019.
 * All rights reserved.
 */
package com.matetoser.adventofcode.dayone;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author matetoser
 * @since 2019. 12. 10.
 */
@Service
public class RocketEquation {

	public Integer calculateSumOfFuelRequirements(){
		List<String> modules = getModules();
		Integer sumOfFuel = 0;
		for(String mass : modules){
			sumOfFuel += fuelCalculation(Integer.valueOf(mass));
		}
		return sumOfFuel;
	}

	private Integer fuelCalculation(Integer mass){
		return (int)Math.floor(mass / 3) - 2;
	}

	private List<String> getModules() {
		try {
			File inputFile = new ClassPathResource("dayone/input.txt").getFile();
			List<String> lines = Files.readAllLines(inputFile.toPath());
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}