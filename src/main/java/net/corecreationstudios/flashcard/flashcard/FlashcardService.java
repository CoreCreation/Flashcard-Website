package net.corecreationstudios.flashcard.flashcard;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Hooks it up to injected as a service
@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    @Autowired
    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getFlashcards() {
        return flashcardRepository.findAll();
    }

    public void addNewFlashcard(Flashcard card) {
        Optional<Flashcard> flashcardByFront = flashcardRepository.findFlashcardByFront(card.getFront());

        if (flashcardByFront.isPresent()) {
            throw new IllegalStateException("Flashcard already exists");
        }

        flashcardRepository.save(card);

    }

    @Transactional
    public void updateFlashcard(Flashcard card) {
        if (card.getFront() == null ||
        card.getFront() == "" || 
        card.getBack() == null || 
        card.getBack() == "") {
            return;
        }
        Flashcard cardInDB = flashcardRepository.findById(card.getId())
                .orElseThrow(() -> new IllegalStateException("Flashcard with id " + card.getId() + " does not exist"));
        if (card.getFront() != cardInDB.getFront()) {
            cardInDB.setFront(card.getFront());
        }
        if (cardInDB.getBack() != card.getBack()) {
            cardInDB.setBack(card.getBack());
        }
    }

    public void deleteFlashcard(Long id) {
        boolean exists = flashcardRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Card with id" + id + " does not exist");
        }
        flashcardRepository.deleteById(id);
    }
}
