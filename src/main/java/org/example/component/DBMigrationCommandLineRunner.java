package org.example.component;

import lombok.RequiredArgsConstructor;
import org.example.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBMigrationCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args)  {

    }
}
