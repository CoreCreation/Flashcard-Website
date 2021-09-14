package net.corecreationstudios.flashcard.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/flashcard")
public class FlashcardController {

    private final FlashcardService flashcardService;

    //Hooks it up to receive the injected service
    @Autowired
    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
	public List<Flashcard> getFlashcards(){
		return flashcardService.getFlashcards();
	}

    @PostMapping
    public void addNewFlashcard(@RequestBody Flashcard card){
        flashcardService.addNewFlashcard(card);
    }

    @PutMapping(path = "{cardId}")
    public void updateFlashcardFront(@PathVariable("cardId") Long id, 
                                     @RequestBody Flashcard card) {
        
        flashcardService.updateFlashcard(card);
    }

    @DeleteMapping(path = "{cardId}")
    public void deleteFlashcard(@PathVariable("cardId") Long id){
        flashcardService.deleteFlashcard(id);
    }
}