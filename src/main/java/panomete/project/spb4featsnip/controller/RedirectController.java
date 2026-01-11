package panomete.project.spb4featsnip.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redirect")
@Tag(name = "Redirect Controller", description = "Controller for redirect endpoints")
public class RedirectController {
    private final String GITHUB_URL = "https://github.com/oat431";
    private final String LINKEDIN_URL = "https://www.linkedin.com/in/sahachan-tippimwong/";

    @GetMapping("/github")
    @Operation(
            summary = "Redirect to GitHub",
            description = "Redirect"
    )
    public ResponseEntity<Void> redirectToGoogle() {
        return ResponseEntity.status(301)
                .header("Location", GITHUB_URL)
                .build();
    }

    @GetMapping("/linkedin")
    @Operation(
            summary = "Redirect to LinkedIn",
            description = "Redirect"
    )
    public ResponseEntity<Void> redirectToLinkedIn() {
        return ResponseEntity.status(301)
                .header("Location", LINKEDIN_URL)
                .build();
    }
}
