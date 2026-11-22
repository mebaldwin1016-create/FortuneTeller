import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;

    private String[] fortunes = {
            "You will accidentally become famous for something silly.",
            "A pizza is in your future.",
            "Your code will compile on the first try. Maybe.",
            "Someone will laugh at your joke today.",
            "You will find money in a pocket.",
            "A nap may solve your problems.",
            "Beware of shopping while hungry.",
            "An A is hiding in your future.",
            "A mysterious email will arrive soon.",
            "Coffee will greatly improve your day.",
            "You will survive your programming assignment.",
            "Luck favors those who save their work often."
    };

    private int lastFortune = -1;

    public FortuneTellerFrame() {

        setTitle("Fortune Teller");

        createComponents();
        setupFrame();
    }

    private void setupFrame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int)(screenSize.width * 0.75);
        int height = (int)(screenSize.height * 0.75);

        setSize(width, height);
        setLocationRelativeTo(null);
    }

    private void createComponents() {

        setLayout(new BorderLayout());

        Font titleFont = new Font("Serif", Font.BOLD, 42);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
        Font textFont = new Font("Monospaced", Font.PLAIN, 18);

        //----------------------------------
        // TOP PANEL
        //----------------------------------

        JPanel topPanel = new JPanel();

        ImageIcon icon = new ImageIcon("fortune.png");

        JLabel titleLabel =
                new JLabel("Fortune Teller", icon, JLabel.CENTER);

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel);

        //----------------------------------
        // MIDDLE PANEL
        //----------------------------------

        fortuneArea = new JTextArea();

        fortuneArea.setFont(textFont);
        fortuneArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(fortuneArea);

        //----------------------------------
        // BOTTOM PANEL
        //----------------------------------

        JPanel bottomPanel = new JPanel();

        JButton fortuneButton =
                new JButton("Read My Fortune!");

        JButton quitButton =
                new JButton("Quit");

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        //----------------------------------
        // Lambda Expressions
        //----------------------------------

        fortuneButton.addActionListener(event -> {

            Random random = new Random();

            int index;

            do {
                index = random.nextInt(fortunes.length);
            }
            while(index == lastFortune);

            lastFortune = index;

            fortuneArea.append(
                    fortunes[index] + "\n"
            );
        });

        quitButton.addActionListener(event -> {
            System.exit(0);
        });

        //----------------------------------
        // Add Panels
        //----------------------------------

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}