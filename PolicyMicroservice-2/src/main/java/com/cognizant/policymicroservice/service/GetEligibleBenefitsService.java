package com.cognizant.policymicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.repository.BenefitRepo;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;

@Service
public class GetEligibleBenefitsService {
	
	@Autowired
	MemberPolicyRepo memberPolicyRepo;

	@Autowired
	BenefitRepo benefitRepo;

	     
	public List<Benefits> calculateEligibleBenefits(int policyId, int memberId) {
		
		List<MemberPolicy> providers = memberPolicyRepo.findAllByPolicyIdAndMemberId(policyId, memberId);

		List<Benefits> benefitDetails = new ArrayList<Benefits>();
		for (MemberPolicy memberPolicy : providers) {
			int benefitId = memberPolicy.getBenefitId();
			benefitDetails.add(getBenefitId(benefitId));

		}
		
		return benefitDetails;
		
	}
	
	// Created method to get benefits

			Benefits getBenefitId(int benefitId) {
				return benefitRepo.findByBenefitId(benefitId);
			}
	

}
