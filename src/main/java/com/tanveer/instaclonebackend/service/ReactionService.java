package com.tanveer.instaclonebackend.service;

import com.tanveer.instaclonebackend.dto.ReactionDTO;
import com.tanveer.instaclonebackend.model.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactionService {
    List<ReactionDTO> getAllReaction();

    ReactionDTO addReaction(ReactionDTO reactionDTO);

    ReactionDTO findReaction(long reactionId);

    ReactionDTO deleteReaction(long reactionId);

    ReactionDTO updateReaction(Long reactionId, ReactionDTO reactionDTO);
}
