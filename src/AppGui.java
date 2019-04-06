import model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppGui {
    private JPanel root;
    private JTextField cityTextField;
    private JTextField countryTextField;
    private JTextArea resutlTextArea;
    private JLabel Country;
    private JLabel City;
    private JLabel stars;
    private JButton filterBtn;
    private JTextField starsTextField;
    private JTextField priceTextField;
    private JTextField typeTextField;
    private JLabel price;
    private JLabel type;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Filter Hotels");
        frame.setContentPane(new AppGui().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(470,400);
        frame.setVisible(true);
    }

    public AppGui() {
        filterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Hotel> hotelList = new ArrayList<>();
                try {
                    hotelList = ExcelReader.listLoader();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                List<Hotel> filteredHotels = Filter.filterHotels(
                        countryTextField.getText(),
                        cityTextField.getText(),
                        Integer.parseInt(starsTextField.getText()),
                        Double.parseDouble(priceTextField.getText()),
                        typeTextField.getText(),
                        hotelList
                );
                for(Hotel hotel: filteredHotels){
                    resutlTextArea.append(String.format("Name: %s, Country: %s, City: %s, Stars: %s \n",
                            hotel.getName(),
                            hotel.getCountry(),
                            hotel.getCity(),
                            hotel.getStars()));
                }


            }
        });
    }
}
