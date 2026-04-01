package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();
    private Color currentSelectedColor = Color.BLACK;
    private JCheckBox cbFilled = new JCheckBox("Filled");
    private Random random = new Random();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(canvas, BorderLayout.CENTER);
        add(createToolbar(), BorderLayout.NORTH);

        initSampleData();
        pack();
    }

    private void initSampleData() {
        GraphicGroup group = new GraphicGroup();
        group.add(new Square(new Point(210, 210), Color.GREEN, 40));
        group.add(new Circle(new Point(260, 210), Color.RED, 40));
        canvas.add(group);


        canvas.add(new Square(new Point(50, 50), Color.ORANGE, 50));
        canvas.add(new Circle(new Point(260, 50), Color.RED, 50));
        canvas.add(new Rectangle(new Point(260, 210), Color.CYAN, 50, 100));
        canvas.add(new Triangle(new Point(350,400),Color.BLACK,50));
    }

    private JToolBar createToolbar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);


        JButton btColor = new JButton("Select Color");
        btColor.setBackground(Color.BLACK);
        btColor.setForeground(Color.WHITE);
        btColor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Select Color", currentSelectedColor);
            if (c != null) {
                currentSelectedColor = c;
                btColor.setBackground(c);
                btColor.setForeground(c.equals(Color.BLACK) ? Color.WHITE : Color.BLACK);
            }
        });
        tb.add(btColor);

        tb.add(cbFilled);
        tb.addSeparator();


        // Square
        JButton btSquare = new JButton("Square");
        btSquare.addActionListener(e -> {
            int x = random.nextInt(Math.max(1, canvas.getWidth() - 100));
            int y = random.nextInt(Math.max(1, canvas.getHeight() - 100));
            int size = 20 + random.nextInt(80);

            Square s = new Square(new Point(x, y), currentSelectedColor, size);
            s.setFilled(cbFilled.isSelected());
            canvas.add(s);
        });
        tb.add(btSquare);

        JButton btCircle = new JButton("Circle");
        btCircle.addActionListener(e -> {
            int x = random.nextInt(Math.max(1, canvas.getWidth() - 100));
            int y = random.nextInt(Math.max(1, canvas.getHeight() - 100));
            int size = 20 + random.nextInt(80);

            Circle c = new Circle(new Point(x, y), currentSelectedColor, size);
            c.setFilled(cbFilled.isSelected());
            canvas.add(c);
        });
        tb.add(btCircle);

        JButton btRectangle = new JButton("Rectangle");
        btRectangle.addActionListener(e -> {
            int x = random.nextInt(Math.max(1, canvas.getWidth() - 150));
            int y = random.nextInt(Math.max(1, canvas.getHeight() - 100));
            int w = 30 + random.nextInt(100);
            int h = 20 + random.nextInt(80);

            Rectangle r = new Rectangle(new Point(x, y), currentSelectedColor, w, h);
            r.setFilled(cbFilled.isSelected());
            canvas.add(r);
        });
        tb.add(btRectangle);

        JButton btTriangle = new JButton("Triangle");
        btTriangle.addActionListener(e -> {
            int x = random.nextInt(Math.max(1, canvas.getWidth() - 100));
            int y = random.nextInt(Math.max(1, canvas.getHeight() - 100));
            int size = 30 + random.nextInt(70);

            Triangle t = new Triangle(new Point(x, y), currentSelectedColor, size);
            t.setFilled(cbFilled.isSelected());
            canvas.add(t);
        });
        tb.add(btTriangle);

        tb.addSeparator();

        JButton btClear = new JButton("Clear");
        btClear.addActionListener(e -> canvas.clear());
        tb.add(btClear);

        return tb;
    }
}