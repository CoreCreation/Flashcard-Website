package net.corecreationstudios.flashcard.flashcard;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository 
    extends JpaRepository<Flashcard, Long> {

        //SELECT * FROM flashcard WHERE front = X
        @Query("SELECT f FROM Flashcard f WHERE f.front = ?1")
        Optional<Flashcard> findFlashcardByFront(String front);
    
}
