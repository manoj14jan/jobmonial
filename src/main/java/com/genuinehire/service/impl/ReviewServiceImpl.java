package com.genuinehire.service.impl;

import com.genuinehire.domain.Review;
import com.genuinehire.repository.ReviewRepository;
import com.genuinehire.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
