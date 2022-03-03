package com.bilal.instaclonebackend.service;

import com.bilal.instaclonebackend.dto.ReactionDTO;
import com.bilal.instaclonebackend.model.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactionService {
    List<ReactionDTO> getAllReaction();

    ReactionDTO addReaction(Reaction reaction);

    ReactionDTO findReaction(long reactionId);

    ReactionDTO deleteReaction(long reactionId);
}
