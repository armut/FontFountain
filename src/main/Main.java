package main;

import colorChooser.BackgroundColorChooser;
import colorChooser.FontColorChooser;
import fenestra.*;
import fountain.FontFountain;
import selector.FontSelector;
import selector.FontSize;

import javax.swing.*;

public class Main {
    static final int WIDTH = 400;
    static final int HEIGHT = 150;
    static FontFountain ff;
    public static Floris fontSelectorDialog;
    public static Floris fontSizeDialog;
    public static Floris fontColorChooserDialog;
    public static Floris backgroundColorChooserDialog;

    public static void main(String[] args) {
        System.out.println("Where the story begins.");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ff = new FontFountain(Palette.deepTaupe, Palette.paynesGrey,
                        Palette.middleRedPurple, "Font Fountain", WIDTH, HEIGHT);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("I am fontSelectorDialog!");
                        if(ff != null) {
                            FontSelector fs = new FontSelector(Palette.deepTaupe, WIDTH, HEIGHT);
                            fontSelectorDialog = new Floris(ff, Palette.deepTaupe, Palette.paynesGrey, Palette.middleRedPurple, "Font Selector", 200, 450);
                            fontSelectorDialog.add(fs.getPanel());
                            fs.getHandler().registerObserver(ff);
                            fs.getHandler().registerObserver(ff.getStatusPanel());
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("I am fontSizeDialog!");
                        if(ff != null) {
                            FontSize fs = new FontSize(Palette.paynesGrey);
                            fontSizeDialog = new Floris(ff, Palette.deepTaupe, Palette.paynesGrey, Palette.middleRedPurple, "Font Size", 125, 250);
                            fontSizeDialog.add(fs);
                            fs.getHandler().registerObserver(ff);
                            fs.getHandler().registerObserver(ff.getStatusPanel());
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("I am fontColorChooser!");
                        if(ff != null) {
                            fontColorChooserDialog = new Floris(ff, Palette.deepTaupe, Palette.paynesGrey,
                                    Palette.middleRedPurple, "Font Color Chooser", 625, 275);
                            fontColorChooserDialog.add(new FontColorChooser());
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("I am backgroundColorChooser!");
                        if(ff != null) {
                            backgroundColorChooserDialog = new Floris(ff, Palette.deepTaupe, Palette.paynesGrey,
                                    Palette.middleRedPurple, "Background Color Chooser", 635, 275);
                            backgroundColorChooserDialog.add(new BackgroundColorChooser());
                        }
                    }
                }).start();

            }
        });
    }
}
