
package com.crio.jukebox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AppTest")
public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){

        //Arrange
        List<String> arguments= new ArrayList<>(List.of("INPUT_FILE=jukebox-input.txt"));

		String expectedOutput = "Songs Loaded successfully\r\n"+
        "1 Kiran\r\n"+
        "Playlist ID - 1\r\n"+
        "Playlist ID - 2\r\n"+
        "Delete Successful\r\n"+
        "Current Song Playing\n"+
        "Song - South of the Border\n"+
        "Album - No.6 Collaborations Project\n"+
        "Artists - Ed Sheeran,Cardi.B,Camilla Cabello\r\n"+
        "Playlist ID - 1\n"+
        "Playlist Name - MY_PLAYLIST_1\n"+
        "Song IDs - 1 4 5 6 7\r\n"+
        "Playlist ID - 1\n"+
        "Playlist Name - MY_PLAYLIST_1\n"+
        "Song IDs - 1 4 5 6\r\n"+
        "Current Song Playing\n"+
        "Song - Cross Me\n"+
        "Album - No.6 Collaborations Project\n"+
        "Artists - Ed Sheeran,Chance The Rapper,PnB Rock\r\n"+
        "Current Song Playing\n"+
        "Song - Give Life Back To Music\n"+
        "Album - Random Access Memories\n"+
        "Artists - Daft Punk,Nile Rodgers\r\n"+
        "Current Song Playing\n"+
        "Song - South of the Border\n"+
        "Album - No.6 Collaborations Project\n"+
        "Artists - Ed Sheeran,Cardi.B,Camilla Cabello\r\n"+
        "Current Song Playing\n"+
        "Song - Give Life Back To Music\n"+
        "Album - Random Access Memories\n"+
        "Artists - Daft Punk,Nile Rodgers\r\n"+
        "Current Song Playing\n"+
        "Song - Cross Me\n"+
        "Album - No.6 Collaborations Project\n"+
        "Artists - Ed Sheeran,Chance The Rapper,PnB Rock\r\n"+
        "Given song id is not a part of the active playlist";
        //Act
        App.run(arguments);
        
        // int count1 = outputStreamCaptor.toString().trim().compareTo("");
        // int count2 = expectedOutput.compareTo("");
        // int count = outputStreamCaptor.toString().trim().compareTo(expectedOutput);
        //System.out.println(count1 +" "+ count2);

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
 
	}

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
