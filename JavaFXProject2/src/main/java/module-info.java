module sample {
  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.fxml;

  opens sample;
  opens sample.controller;
  opens sample.logic;
  opens sample.model;
}