package dev.jvictor.chess.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dev.jvictor.chess.bootstrap.ports.GameViewer;
import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.io.InMemoryKeyboard;
import dev.jvictor.chess.io.InMemoryMessageCrossingFactory;
import dev.jvictor.chess.io.InMemoryPersistence;
import dev.jvictor.chess.io.NoViewAdapter;
import dev.jvictor.chess.machinecore.ports.MessageCrossingFactory;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler.ShellState;
import dev.jvictor.chess.machinecore.shell.ChallengeCommand;
import dev.jvictor.chess.machinecore.shell.ChangeCommand;
import dev.jvictor.chess.machinecore.shell.CommandReader;
import dev.jvictor.chess.machinecore.shell.ResignCommand;
import dev.jvictor.chess.machinecore.shell.ListCommand;
import dev.jvictor.chess.machinecore.shell.MoveCommand;
import dev.jvictor.chess.machinecore.shell.ShellMachine;
import dev.jvictor.chess.machinecore.shell.ShellMachine.ShellMode;

public class IntegrationTest {
    
    ShellMachine machine;

    @BeforeAll
    public void resetBoard() {
        Keyboard keyboard = new InMemoryKeyboard();
        PersistenceAdapter persistence = new InMemoryPersistence();
        GameViewer gameViewer = new NoViewAdapter();
        String user = "jose";
        List<String> movements= new ArrayList<>();
        MessageCrossingFactory messageCrossingFactory = new InMemoryMessageCrossingFactory();
        CommandReader commandReader = new CommandReader(keyboard);
        ListCommand listCommand = new ListCommand(persistence);
        ChangeCommand changeCommand = new ChangeCommand(persistence, keyboard, gameViewer, movements, user, messageCrossingFactory);
        MoveCommand moveCommand = new MoveCommand(keyboard);
        ResignCommand resignCommand = new ResignCommand(persistence, keyboard, user);
        ChallengeCommand challengeCommand = new ChallengeCommand(persistence, keyboard, user);
        machine = new ShellMachine(Map.of(
            ShellState.READING, commandReader,
            ShellState.CHALLENGING, challengeCommand,
            ShellState.LISTING, listCommand,
            ShellState.CHANGING, changeCommand,
            ShellState.RESIGNING, resignCommand,
            ShellState.MOVING, moveCommand
        ), ShellMode.WHILE_THERE_ARE_MESSAGES);
    }
}
