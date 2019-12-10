/*
 * Copyright © ShiwaForce.com Zrt. 2012 - 2019.
 * All rights reserved.
 */
package com.matetoser.adventofcode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matetoser.adventofcode.dayone.RocketEquation;

import lombok.RequiredArgsConstructor;

/**
 * @author matetoser
 * @since 2019. 12. 10.
 */
@RestController
@RequestMapping("/challanges")
@RequiredArgsConstructor
public class ChallangesController {

	private final RocketEquation rocketEquation;

	@GetMapping("/dayone")
	public Integer dayOne() {
		return rocketEquation.calculateSumOfFuelRequirements();
	}

	@GetMapping("/dayone/parttwo")
	public Integer dayOnePartTwo() {
		return rocketEquation.calculateSumOfFuelRequirementsPartTwo();
	}
}
