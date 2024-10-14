import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Visualizer extends JFrame implements ActionListener {

    // WIDTH & HEIGHT is the width and height of the window/screen
    public static final int WIDTH = 1620;
    public static final int HEIGHT = 1200;
    public static boolean sorted = false;
    public static char sortingAlgo;

    JLabel title, name, timeComplexity, spaceComplexity;
    JButton shuffle, visualize;
    JComboBox<String> algorithms;
    Dimension titleSize, tcSize, scSize;
    JPanel mainPanel = new JPanel();
    ArrayList<Integer> heights = generateArr();
    DrawRect rectArr = new DrawRect(heights);

    BubbleSort bs = new BubbleSort();
    InsertionSort is = new InsertionSort();
    SelectionSort ss = new SelectionSort();
    MergeSort ms = new MergeSort();
    QuickSort qs = new QuickSort();

    public Visualizer() throws InterruptedException {
        // Frame variables
        this.setTitle("Sorting Algorithms Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setSize(WIDTH, HEIGHT);

        // Panels
        mainPanel.setBackground(new Color(0,32,63));
        mainPanel.setBounds(0, 0, WIDTH, 230);
        mainPanel.setLayout(null);

        rectArr.setBackground(new Color(0,32,63));
        rectArr.setBounds(0, 230, WIDTH, 900);



        // Displayed Labels
        title = new JLabel("SORTING ALGORITHMS VISUALIZER");
        title.setForeground(new Color(175,239,209));
        titleSize = title.getPreferredSize();
        title.setBounds(440, 20, titleSize.width + 545, titleSize.height + 65);
        title.setFont(new Font("Arial", Font.BOLD, 40));

        name = new JLabel("Developed by: Srishti Sharma");
        name.setForeground(new Color(175,239,209));
        name.setBounds(580, 100, 545, 65);
        name.setFont(new Font("Arial", Font.BOLD, 26));

        timeComplexity = new JLabel("Time Complexity: ");
        timeComplexity.setForeground(new Color(175,239,209));
        tcSize = timeComplexity.getPreferredSize();
        timeComplexity.setBounds(10, 20, tcSize.width + 300, tcSize.height + 50);
        timeComplexity.setFont(new Font("Arial", Font.BOLD, 22));

        spaceComplexity = new JLabel("Space Complexity: ");
        spaceComplexity.setForeground(new Color(175,239,209));
        scSize = spaceComplexity.getPreferredSize();
        spaceComplexity.setBounds(10, 70, scSize.width + 300, scSize.height + 50);
        spaceComplexity.setFont(new Font("Arial", Font.BOLD, 22));


        // Drop-down menu
        algorithms = new JComboBox<String>(new String[]{"Select Algorithm", "Bubble Sort", "Insertion Sort","Selection Sort" ,"Merge Sort","Quick Sort"});
        algorithms.setBounds(1320, 30, 280, 40);
        algorithms.setFont(new Font("Arial", Font.BOLD, 24));
        algorithms.setBackground(new Color(0,32,63)); // Example background color
        algorithms.setForeground(new Color(175,239,209)); // Example text color

        // Buttons
        visualize = new JButton("Visualize");
        visualize.setBounds(1360, 90, 200, 40);
        visualize.setFont(new Font("Arial", Font.BOLD, 24));
        visualize.setBackground(new Color(163,184,204)); // Example background color
        visualize.setForeground(new Color(0,32,63)); // Example text color

        shuffle = new JButton("Shuffle");
        shuffle.setBounds(1360, 150, 200, 40);
        shuffle.setFont(new Font("Arial", Font.BOLD, 24));
        shuffle.setBackground(new Color(163,184,204)); // Example background color
        shuffle.setForeground(new Color(0,32,63)); // Example text color

        // Adding labels to the main panel
        mainPanel.add(algorithms);
        mainPanel.add(visualize);
        mainPanel.add(shuffle);
        mainPanel.add(title);
        mainPanel.add(name);
        mainPanel.add(timeComplexity);
        mainPanel.add(spaceComplexity);


        // Adding panels to the frame
        this.add(mainPanel);
        this.add(rectArr);
        this.validate();
        this.setVisible(true);

        // Handling User Input
        Visualizer handler = this;
        algorithms.addActionListener(handler);
        visualize.addActionListener(handler);
        shuffle.addActionListener(handler);
    }

    // Generating a new shuffled array
    public ArrayList<Integer> generateArr() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int y = 1100; y >= 265; y -= 18)
            arr.add(y);
        Collections.shuffle(arr);
        System.out.println(arr);
        return arr;
    }

    // Event Handling
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == algorithms) {
//            noOfComparisons = 0;
            if (algorithms.getSelectedItem() == "Bubble Sort") {
                sortingAlgo = 'b';
                timeComplexity.setText("Time Complexity: O(n^2)");
                spaceComplexity.setText("Space Complexity: O(1)");
            }else if (algorithms.getSelectedItem() == "Insertion Sort") {
                sortingAlgo = 'i';
                timeComplexity.setText("Time Complexity: O(n^2)");
                spaceComplexity.setText("Space Complexity: O(1)");
            }
            else if (algorithms.getSelectedItem() == "Selection Sort") {
                sortingAlgo = 's';
                timeComplexity.setText("Time Complexity: O(n^2)");
                spaceComplexity.setText("Space Complexity: O(1)");
            }else if (algorithms.getSelectedItem() == "Merge Sort") {
                sortingAlgo = 'm';
                timeComplexity.setText("Time Complexity: O(nlog(n))");
                spaceComplexity.setText("Space Complexity: O(n)");
            }else if (algorithms.getSelectedItem() == "Quick Sort") {
                sortingAlgo = 'q';
                timeComplexity.setText("Time Complexity: O(n^2)");
                spaceComplexity.setText("Space Complexity: O(n)");
            }
            else {
                sortingAlgo = 'x';
            }
        } else if (event.getSource() == visualize && !sorted) {
            if (sortingAlgo == 'b') {
                try {
                    bs.sort(heights, rectArr, this);
                    sorted = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (sortingAlgo == 'i') {
                try {
                    is.sort(heights, rectArr, this);
                    sorted = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (sortingAlgo == 's') { // Added Selection Sort action
                try {
                    ss.sort(heights, rectArr, this);
                    sorted = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (sortingAlgo == 'm') {
                try {
                    ms.sort(heights, 0, heights.size() - 1, rectArr, this);
                    sorted = true;
//                    noOfComparisons = 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (sortingAlgo == 'q') {
                try {
                    qs.sort(heights, 0, heights.size() - 1, rectArr, this);
                    sorted = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (event.getSource() == shuffle) {
            heights = generateArr();
            rectArr.removeAll();
            rectArr.setArr(heights);
            rectArr.revalidate();
            rectArr.paintImmediately(0, 230, WIDTH, 900);
            sorted = false;
        }

    }

}

