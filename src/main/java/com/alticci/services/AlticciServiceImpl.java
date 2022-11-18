package com.alticci.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlticciServiceImpl implements AlticciService {

	private final Map<Integer, Long> sequences = new HashMap<>();

	public AlticciServiceImpl() {
		this.sequences.put(0, 0L);
		this.sequences.put(1, 1L);
		this.sequences.put(2, 1L);
	}

	@Override
	public Long getAlticciSequence(Integer index) {
		if (this.sequences.containsKey(index)) {
			return this.sequences.get(index);
		}

		return this.createSequence(index);
	}

	private Long createSequence(Integer index) {
		Long sequenceOne = this.sequences.containsKey(index - 3)
				? this.sequences.get(index - 3) : createSequence(index - 3);

		Long sequenceTwo = this.sequences.containsKey(index - 2)
				? this.sequences.get(index - 2) : createSequence(index - 2);

		this.sequences.put(index , sequenceOne + sequenceTwo);

		return this.sequences.get(index);
	}

}
