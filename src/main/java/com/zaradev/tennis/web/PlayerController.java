package com.zaradev.tennis.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaradev.tennis.Player;
import com.zaradev.tennis.PlayerList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Tennis Players API")
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Operation(summary = "Finds players", description = "Finds Players")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Players List",
            content = { @Content(mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Player.class)) )})
    })
    @GetMapping
    public List<Player> list() {
        return PlayerList.ALL;
    }

    @Operation(summary = "Finds a player", description = "Finds a player")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Player",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = Player.class))})
    })
    @GetMapping("{lastName}")
    public Player getByLastName(@PathVariable String lastName){
        return PlayerList.ALL.stream()
                .filter(player -> player.lastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Operation(summary = "Create a player", description = "Create a player")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Created Player",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = Player.class))})
    })
    @PostMapping
    public Player createPlayer(@RequestBody Player player){
        return player;
    }

    @Operation(summary = "Update a player", description = "update a player")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated player",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = Player.class))})
    })
    @PutMapping
    public Player updatePlayer(@RequestBody Player player){
        return player;
    }

    @Operation(summary = "Delete a player", description = "Delete a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Player has been deleted")
    })
    @DeleteMapping("{lastName}")
    public void deletePlayerByLastName(@PathVariable String lastName){
        System.out.println("Player deleted");
    }
}
