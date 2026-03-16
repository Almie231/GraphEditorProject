package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.model.Square;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
        initSampleData();
        pack();
    }

    private void initSampleData() {
        canvas.add(new Square(new Point(100,100),Color.black,50));
        canvas.add(new Square(new Point(100,200),Color.black,50));
        canvas.add(new Square(new Point(200,100),Color.black,50));
        canvas.add(new Rectangle(new Point(200,200),Color.black,50,100));
        canvas.add(new Rectangle(new Point(250,350),Color.black,50,100));
        canvas.add(new Rectangle(new Point(350,250),Color.black,50,100));

    }
}
