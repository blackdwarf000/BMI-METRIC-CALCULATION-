/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author pc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
public class BMI extends JFrame{
    
    private Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //getting the size of the screen
    private JPanel panel1,panel2;
    private JButton compute;
    private JTextField height,weight;
    private JLabel h,w,kilo,centi;
  
  BMI(){
      //frame layout
    this.setSize(size.width/3 - 50,size.height/2);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Body Mas Index(METRIC)");
    this.setResizable(false);
    this.setVisible(true);

    //add components
    panel();
    this.add(panel1);
  
  } 
  
 private void panel(){
    panel1 = new JPanel();
    panel1.setVisible(true);
    panel1.setBackground(Color.white);
    
    panel1.setLayout(null);
 //add components
    panel2();
    panel1.add(panel2);
    
  
 }
 
 private void panel2(){
    panel2 = new JPanel();
    SpringLayout lay = new SpringLayout();
    panel2.setLayout(lay);
    panel2.setVisible(true);
    panel2.setBackground(Color.white); 
  //  panel2.setBorder(BorderFactory.createTitledBorder("BMI"));
    panel2.setSize(300,300);
    panel2.setLocation(new Point(100,100));
            
    
    //add componenets
    height();
    panel2.add(h);
    panel2.add(height);
    panel2.add(centi);
    width();
    panel2.add(w);
    panel2.add(weight);
    panel2.add(kilo);
    compute();
    panel2.add(compute);
   
    
    //h
    lay.putConstraint(SpringLayout.WEST, h, 5, SpringLayout.WEST,panel2);
    //heigth 
    lay.putConstraint(SpringLayout.WEST, height, 5,SpringLayout.EAST,h);
    //kilo
    lay.putConstraint(SpringLayout.WEST, centi, 3, SpringLayout.EAST,height);
    //w
    lay.putConstraint(SpringLayout.NORTH, w, 10 , SpringLayout.SOUTH,h);
    lay.putConstraint(SpringLayout.WEST, w, 5, SpringLayout.WEST,panel2);
    
    //width
    lay.putConstraint(SpringLayout.NORTH, weight, 7, SpringLayout.SOUTH,height);
    lay.putConstraint(SpringLayout.WEST, weight, 2, SpringLayout.EAST,w);
     //centi
    lay.putConstraint(SpringLayout.WEST, kilo, 3, SpringLayout.EAST,weight);
    lay.putConstraint(SpringLayout.NORTH, kilo, 10, SpringLayout.SOUTH,centi);
    //compute
    lay.putConstraint(SpringLayout.NORTH, compute, 25, SpringLayout.SOUTH, weight);
    lay.putConstraint(SpringLayout.WEST, compute, -5 , SpringLayout.EAST, w);
 }
 
 private void compute(){
     compute = new JButton("Compute");
     compute.setActionCommand("compute");
     compute.addActionListener(new compute());
     compute.setFont(new Font("Aial",Font.ITALIC,13));
 }
 
 private void height(){
      h = new JLabel("Height : ");
      h.setFont(new Font("Aial",Font.ITALIC,13));
      centi = new JLabel("cm");
      centi.setFont(new Font("Aial",Font.ITALIC,11));
      height = new JTextField(5);
  }
  
 private void width(){
      w = new JLabel("Weight : ");
      w.setFont(new Font("Aial",Font.ITALIC,13));
        kilo = new JLabel("kg");
      kilo.setFont(new Font("Aial",Font.ITALIC,11));
      weight = new JTextField(5);
  }
  
 public static void main(String[] args) {
     
        BMI bmi = new BMI();
 }
    
    private class compute implements ActionListener{
        public void actionPerformed(ActionEvent e){
          String command = e.getActionCommand(); 
            if(command.equals("compute")){
          if(height.getText().equals("") || weight.getText().equals("")){
            JOptionPane.showMessageDialog(null,"There's an empty field","BMI Result",JOptionPane.INFORMATION_MESSAGE);
          }
          else if(!Pattern.matches("^[0-9]*$", height.getText()) || !Pattern.matches("^[0-9]*$", weight.getText())){
              JOptionPane.showMessageDialog(null,"Invalid","BMI Result",JOptionPane.INFORMATION_MESSAGE);
              height.setText("");
              weight.setText("");
          }
          else{
               int hei = Integer.parseInt(height.getText());
               int wid = Integer.parseInt(weight.getText());
               double total =  Math.round(Math.pow(hei,2) / wid);
               if(total < 18.5){
                     JOptionPane.showMessageDialog(null,"Your BMI is " + total + " and you are UNDERWEIGHT","BMI Result",JOptionPane.INFORMATION_MESSAGE);
               }
               else if(total > 24.9){
                     JOptionPane.showMessageDialog(null,"Your BMI is " + total + " and you are OVERWEIGHT","BMI Result",JOptionPane.INFORMATION_MESSAGE);
               }
             else{
                 JOptionPane.showMessageDialog(null,"Your BMI is " + total + " and you are NORMAL","BMI Result",JOptionPane.INFORMATION_MESSAGE);
             }
          }
          
          
            }
        }
    }
    
}
