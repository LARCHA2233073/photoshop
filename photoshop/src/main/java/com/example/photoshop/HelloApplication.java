package com.example.photoshop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static javafx.scene.control.skin.MenuBarSkin.setDefaultSystemMenuBar;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        stage.setFullScreen(true);
        ColorAdjust colorAdjust = new ColorAdjust();

        Text barreEtat = new Text("Lancement de programme");

        ImageView imageAffiche = new ImageView();
        imageAffiche.setPreserveRatio(true);
        imageAffiche.setFitWidth(500);

        //creer borderPane
        BorderPane borderPane = new BorderPane();

        //image
        Image image1 = new Image(new FileInputStream("image1Montagne.jpeg"));

        Image image2 = new Image(new FileInputStream("image2Etoile.png"));

        Image image3 = new Image(new FileInputStream("image3Seigneur.jpeg"));

        //sliders et effets
        VBox vboxSliders = new VBox();
        vboxSliders.setSpacing(5);

        Slider sliderLuminosite = new Slider(-1, 1, 0);
        sliderLuminosite.setBlockIncrement(0.01);
        sliderLuminosite.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            colorAdjust.setBrightness(0.5 * newValue.doubleValue());
            imageAffiche.setEffect(colorAdjust);
            barreEtat.setText("Changement de luminosité");
        });

        Slider sliderContraste = new Slider(-1, 1, 0);
        sliderContraste.setBlockIncrement(0.01);
        sliderContraste.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            colorAdjust.setContrast(0.5 * newValue.doubleValue());
            imageAffiche.setEffect(colorAdjust);
            barreEtat.setText("Changement de contraste");
        });
        Slider sliderTeinte = new Slider(-1, 1, 0);
        sliderTeinte.setBlockIncrement(0.01);
        sliderTeinte.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            colorAdjust.setHue(0.5 * newValue.doubleValue());
            imageAffiche.setEffect(colorAdjust);
            barreEtat.setText("Changement de teinte");
        });
        Slider sliderSaturation = new Slider(-1, 1, 0);
        sliderSaturation.setBlockIncrement(0.01);
        sliderSaturation.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            colorAdjust.setSaturation(0.5 * newValue.doubleValue());
            imageAffiche.setEffect(colorAdjust);
            barreEtat.setText("Changement de saturation");
        });

        vboxSliders.getChildren().addAll(new Text("Luminosité"), sliderLuminosite, new Text("Contraste"),
                sliderContraste, new Text("Teinte"), sliderTeinte, new Text("Saturation"), sliderSaturation);

        //tooltip
        Tooltip tooltipLuminosite = new Tooltip("Rend l'image plus claire ou plus sombre");
        sliderLuminosite.setTooltip(tooltipLuminosite);

        Tooltip tooltipContraste = new Tooltip("Diminue ou augmente la différence entre les couleurs");
        sliderContraste.setTooltip(tooltipContraste);

        Tooltip tooltipTeinte = new Tooltip("Change la teinte (couleur) de l'image");
        sliderTeinte.setTooltip(tooltipTeinte);

        Tooltip tooltipSaturation = new Tooltip("Diminue ou augmente l'intensité des couleurs");
        sliderSaturation.setTooltip(tooltipSaturation);

        //creer menu

        Menu fichers = new Menu("Fichiers");
        Menu chargerImage = new Menu("Charger une image");

        MenuItem menuImage1 = new MenuItem("Charger image 1");
        menuImage1.setOnAction( (e) -> {
            imageAffiche.setImage(image1);
            barreEtat.setText("Chargement de l'image 1");
        });

        MenuItem menuImage2 = new MenuItem("Charger image 2");
        menuImage2.setOnAction( (e) -> {
            imageAffiche.setImage(image2);
            barreEtat.setText("Chargement de l'image 2");
        });

        MenuItem menuImage3 = new MenuItem("Charger image 3");
        menuImage3.setOnAction( (e) -> {
            imageAffiche.setImage(image3);
            barreEtat.setText("Chargement de l'image 3");
        });

        chargerImage.getItems().addAll(menuImage1, menuImage2, menuImage3);
        fichers.getItems().addAll(chargerImage);
        Menu actions = new Menu("Actions");

        MenuItem reinitialiser = new MenuItem("réinitialiser");
        reinitialiser.setOnAction( (e) -> {
            colorAdjust.setSaturation(0);
            colorAdjust.setHue(0);
            colorAdjust.setBrightness(0);
            colorAdjust.setContrast(0);
            imageAffiche.setEffect(colorAdjust);
            sliderLuminosite.setValue(0);
            sliderContraste.setValue(0);
            sliderSaturation.setValue(0);
            sliderTeinte.setValue(0);
            barreEtat.setText("Réinitialisation de l'image");
        });
        actions.getItems().addAll(reinitialiser);
        MenuBar menuBar = new MenuBar(fichers, actions);

        setDefaultSystemMenuBar(menuBar);

        //context menu

        ContextMenu contextMenu = new ContextMenu();
        Menu chargerImageContextMenu = new Menu("Charger une image");

        MenuItem menuImage11 = new MenuItem("Charger image 1");
        menuImage11.setOnAction( (e) -> {
            imageAffiche.setImage(image1);
            barreEtat.setText("Chargement de l'image 1");
        });
        MenuItem menuImage22 = new MenuItem("Charger image 2");
        menuImage22.setOnAction( (e) -> {
            imageAffiche.setImage(image2);
            barreEtat.setText("Chargement de l'image 2");
        });
        MenuItem menuImage33 = new MenuItem("Charger image 3");
        menuImage33.setOnAction( (e) -> {
            imageAffiche.setImage(image3);
            barreEtat.setText("Chargement de l'image 3");
        });
        MenuItem reinitialiserContextMenu = new MenuItem("réinitialiser");
        reinitialiserContextMenu.setOnAction( (e) -> {
            colorAdjust.setSaturation(0);
            colorAdjust.setHue(0);
            colorAdjust.setBrightness(0);
            colorAdjust.setContrast(0);
            imageAffiche.setEffect(colorAdjust);
            sliderLuminosite.setValue(0);
            sliderContraste.setValue(0);
            sliderSaturation.setValue(0);
            sliderTeinte.setValue(0);
            barreEtat.setText("Réinitialisation de l'image");
        });
        Menu actionsContextMenu = new Menu("Actions");
        actionsContextMenu.getItems().addAll(reinitialiserContextMenu);


        chargerImageContextMenu.getItems().addAll(menuImage11, menuImage22, menuImage33);
        contextMenu.getItems().addAll(chargerImageContextMenu, actionsContextMenu);

        vboxSliders.setOnContextMenuRequested( (e) -> {
            contextMenu.show(vboxSliders, e.getSceneX(), e.getSceneY());
        });

        //borderpane et allignement

        borderPane.setTop(menuBar);
        HBox imageEtSliders = new HBox();

        vboxSliders.setTranslateY(350);
        imageEtSliders.setSpacing(15);


        imageEtSliders.getChildren().addAll(imageAffiche, vboxSliders);
        imageEtSliders.setAlignment(Pos.CENTER);
        borderPane.setCenter(imageEtSliders);


        borderPane.setBottom(barreEtat);

        //stage
        stage.setScene(new Scene(borderPane));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}