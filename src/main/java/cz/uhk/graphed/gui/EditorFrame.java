package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.*;
import cz.uhk.graphed.model.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditorFrame extends JFrame {
    private Canvas canvas = new Canvas();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
        add(createToolbar(), BorderLayout.NORTH);
        initSampleData();
        pack();
    }

    private JToolBar createToolbar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);

        Action actSquare =  new AbstractAction("Square") {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.add(new Square(new Point(50,50), Color.BLACK, 50));
            }
        };
        tb.add(actSquare);

        JButton btCircle = new JButton("Circle");
        btCircle.addActionListener(e->canvas.add(
                new Circle(new Point(50,50), Color.BLACK, 50)));
        tb.add(btCircle);

        JButton btRectangle = new JButton("Rectangle");
        btRectangle.addActionListener(e->canvas.add(new Rectangle(new Point(50,50), Color.BLACK, 50,100)));
        tb.add(btRectangle);

        JButton btTriangle = new JButton("Triangle");
        btTriangle.addActionListener(e->canvas.add(new Triangle(new Point(50,50), Color.BLACK, 50)));
        tb.add(btTriangle);
        return tb;
    }

    private void initSampleData() {
        /*
        canvas.add(new Square(new Point(100, 100), Color.black, 50));
        canvas.add(new Square(new Point(100, 200), Color.black, 50));
        canvas.add(new Square(new Point(200, 100), Color.black, 50));
        canvas.add(new Rectangle(new Point(200, 200), Color.black, 50, 100));
        canvas.add(new Rectangle(new Point(250, 350), Color.black, 50, 100));
        canvas.add(new Rectangle(new Point(350, 250), Color.black, 50, 100));
        canvas.add(new Triangle(new Point(400, 400), Color.black, 100));
        canvas.add(new Triangle(new Point(500, 500), Color.black, 50));
        canvas.add(new Circle(new Point(300, 300), Color.black, 100));
        canvas.add(new Circle(new Point(400, 400), Color.black, 50));
        GraphicGroup group = new GraphicGroup();
        canvas.add(group);
        group.add(new Square(new Point(200, 200), Color.BLACK, 100));
        group.add(new Circle(new Point(200, 200), Color.black, 100));
        */
    }
}
