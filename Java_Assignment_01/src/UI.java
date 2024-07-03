import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends Calculator implements ActionListener {

        JFrame calFame =new JFrame("Calculator");

        JTextField disField= new JTextField();

        //1st line
        JButton clrb= new JButton("C");
        JButton delb =new JButton("D");

        //2nd line
        JButton b7 =new JButton("7");
        JButton b8 =new JButton("8");
        JButton b9 =new JButton("9");
        JButton bmulti =new JButton("*");

        //3rd line
        JButton b4 =new JButton("4");
        JButton b5 =new JButton("5");
        JButton b6 =new JButton("6");
        JButton bsum =new JButton("+");

        //4th line
        JButton b1 =new JButton("1");
        JButton b2 =new JButton("2");
        JButton b3 =new JButton("3");
        JButton bsub =new JButton("-");

        //5th line
        JButton bpoint =new JButton(".");
        JButton b0 =new JButton("0");
        JButton beq =new JButton("=");
        JButton bdiv =new JButton("÷");
        int option=0;

        public void UI(){
            setboundinfo();
            addInfo();
            addActionListner();
        }
        public void setboundinfo(){
            disField.setBounds(10,10,240,50);
            disField.setFont(new Font("Arial", Font.BOLD, 19));

            /*set bounds for clear and delete*/
            clrb.setBounds(130,60,60,40);
            delb.setBounds(190,60,60,40);
            //set bounds for 2nd line
            b7.setBounds(10,100,60,40);
            b8.setBounds(70,100,60,40);
            b9.setBounds(130,100,60,40);
            bmulti.setBounds(190,100,60,40);
            //set bounds for 3rd line
            b4.setBounds(10,140,60,40);
            b5.setBounds(70,140,60,40);
            b6.setBounds(130,140,60,40);
            bsum.setBounds(190,140,60,40);
            //set bounds for 4th line
            b1.setBounds(10,180,60,40);
            b2.setBounds(70,180,60,40);
            b3.setBounds(130,180,60,40);
            bsub.setBounds(190,180,60,40);
            //set bounds for 5th line
            bpoint.setBounds(10,220,60,40);
            b0.setBounds(70,220,60,40);
            beq.setBounds(130,220,60,40);
            bdiv.setBounds(190,220,60,40);
        }
        public void addInfo(){
            calFame.add(disField);
            //adding Buttons
            calFame.add(delb);
            calFame.add(clrb);
            calFame.add(b7);
            calFame.add(b8);
            calFame.add(b9);
            calFame.add(bmulti);
            calFame.add(b4);
            calFame.add(b5);
            calFame.add(b6);
            calFame.add(bsum);
            calFame.add(b1);
            calFame.add(b2);
            calFame.add(b3);
            calFame.add(bsub);
            calFame.add(bpoint);
            calFame.add(b0);
            calFame.add(beq);
            calFame.add(bdiv);

            calFame.setLayout(null);
            calFame.setSize(270,300);
            calFame.setVisible(true);
        }
        public void addActionListner(){
            clrb.addActionListener(this);
            delb.addActionListener( this);
            b7.addActionListener(this);
            b8.addActionListener(this);
            b9.addActionListener(this);
            bmulti.addActionListener( this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            bsum.addActionListener( this);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            bsub.addActionListener( this);
            bpoint.addActionListener(this);
            b0.addActionListener(this);
            beq.addActionListener(this);
            bdiv.addActionListener( this);

        }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

        if(source== clrb){ disField.setText("");}
        else if (source==delb) {
            String currentText =disField.getText();
            if(!currentText.isEmpty()){
                disField.setText(currentText.substring(0,currentText.length()-1));
            }
        } else if (source==b7) {
            disField.setText(disField.getText()+"7");
        }
        else if (source==b8) {
            disField.setText(disField.getText()+"8");

        }else if (source==b9) {
            disField.setText(disField.getText()+"9");

        }
        else if (source==bmulti) {
            String str =disField.getText();
            operand_1 =Double.parseDouble(disField.getText());
            option=3;
            disField.setText("");

        }
        else if (source==b4) {
            disField.setText(disField.getText()+"4");

        }
        else if (source==b5) {
            disField.setText(disField.getText()+"5");

        }
        else if (source==b6) {
            disField.setText(disField.getText()+"6");

        }
        else if (source==bsum) {

          operand_1 =Double.parseDouble(disField.getText());
            option=1;
            disField.setText("");
        }
        else if (source==b1) {
            disField.setText(disField.getText()+"1");
        }
        else if (source==b2) {
            disField.setText(disField.getText()+"2");

        }
        else if (source==b3) {
            disField.setText(disField.getText()+"3");

        }
        else if (source==bsub) {

            operand_1 =Double.parseDouble(disField.getText());
            option=2;
            disField.setText("");

        }
        else if (source==bpoint) {
            if(disField.getText().contains(".")){
                return;
            }
            else{
                disField.setText(disField.getText()+".");
            }
        }
        else if (source==b0) {
            disField.setText(disField.getText()+"0");

        }
        else if (source==bdiv) {

            operand_1 =Double.parseDouble(disField.getText());
            option=4;
            disField.setText("");

        }
        else if (source==beq) {
            operand_2= Double.parseDouble(disField.getText());

            if(option==1){
                ans=operand_1+operand_2;
            } else if (option==2) {
                ans=operand_1-operand_2;
            } else if (option ==3) {
                ans=operand_1*operand_2;
            } else if (option==4) {
                ans = operand_1 / operand_2;
                try {
                    render(operand_2);
                } catch (mathErrorException e1) {
                    System.out.println("Math Error" + e1);
                }

            }
            if (Double.toString(ans).endsWith(".0")){
                disField.setText(Double.toString(ans).replace(".0",""));

            }else {
                disField.setText(Double.toString(ans));
            }
        }

    }
    public  void render (double a) throws mathErrorException{
        System.out.println("Can't Divided by zero");
    }


}
