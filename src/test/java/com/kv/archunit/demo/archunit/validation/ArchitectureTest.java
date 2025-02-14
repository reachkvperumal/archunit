package com.kv.archunit.demo.archunit.validation;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.plantuml.rules.PlantUmlArchCondition;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {

    @Test
    public void testLayeredArchitecture() throws Exception {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.kv");
        URL resource = getClass().getResource("/DemoComponent.puml");
        PlantUmlArchCondition.Configuration configuration = PlantUmlArchCondition.Configuration.consideringOnlyDependenciesInDiagram();

        // Define the ArchRule using the PlantUML diagram
        ArchRule rule = classes().should(PlantUmlArchCondition.adhereToPlantUmlDiagram(resource, configuration));
        rule.check(importedClasses);
    }
}
