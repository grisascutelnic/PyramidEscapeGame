package com.game.pyramidescape;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleAnimation {
    private Group particleGroup = new Group();
    private List<Circle> particles = new ArrayList<>();
    private Random random = new Random();

    public ParticleAnimation() {
        // Inițializează particulele
        for (int i = 0; i < 100; i++) {
            Circle particle = createParticle();
            particles.add(particle);
            particleGroup.getChildren().add(particle);
        }

        // Configurează o animație pentru particule
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), event -> {
            for (Circle particle : particles) {
                updateParticle(particle);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public Group getParticleGroup() {
        return particleGroup;
    }

    private Circle createParticle() {
        Circle particle = new Circle(2.5);
        particle.setFill(Color.LIGHTGRAY);
        particle.setOpacity(0.5);
        particle.setCenterX(random.nextInt(1000));
        particle.setCenterY(random.nextInt(700));
        return particle;
    }

    private void updateParticle(Circle particle) {
        double dx = random.nextDouble() * 2 - 1;
        double dy = random.nextDouble() * 2 - 1;
        particle.setCenterX(particle.getCenterX() + dx);
        particle.setCenterY(particle.getCenterY() + dy);

        // Verifică marginile ecranului și resetează poziția particulei
        if (particle.getCenterX() < 0 || particle.getCenterX() > 1000 || particle.getCenterY() < 0 || particle.getCenterY() > 700) {
            particle.setCenterX(random.nextInt(1000));
            particle.setCenterY(random.nextInt(700));
        }
    }
}
