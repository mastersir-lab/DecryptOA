package com.example.demo;

import com.example.demo.FineReport.FineReportDecode;
import com.example.demo.Seeyou.SeeyouDecode;
import com.example.demo.Yonyou.YonyouDecode;
import com.example.demo.ezOFFICE.DecryptDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import com.example.demo.ezOFFICE.DecryptDataBase.*;
import com.example.demo.Landray.LandrayDES.*;
import com.example.demo.Seeyou.SeeyouDecode.*;
import com.example.demo.Landray.LandrayDES;

import static com.example.demo.FineReport.FineReportDecode.frDecrypt;
import static com.example.demo.Landray.LandrayDES.llDecryptCon;

public class Controller {
    //万户解密实现
    @FXML
    private TextArea whDecrypt;

    @FXML
    private Button whDecryptButton;

    @FXML
    private TextArea whDecryptInput;

    @FXML
    void whDecryptButtonAction(ActionEvent event) throws Exception {
        String input_text = whDecrypt.getText();
        if(input_text.length() < 2){
            whDecryptInput.setText(" [-] 输入错误！");
        }else {
            String whDecryptRes = DecryptDataBase.whDecryptCon(input_text);
            whDecryptInput.setText(whDecryptRes);
        }
    }

    //蓝凌解密实现
    @FXML
    private TextArea llDecrypt;
    @FXML
    private TextArea llDecryptInput;
    @FXML
    private ChoiceBox<?> llDecryptBox;
    @FXML
    private Button llDecryptButton;
    @FXML
    void llDecryptButtonAction(ActionEvent event) throws Exception {
        String lanlinginput = llDecrypt.getText();
        int selectedIndex = llDecryptBox.getSelectionModel().getSelectedIndex();
        if (lanlinginput.length() < 2){
            llDecryptInput.setText(" [-] 输入错误！");
        }else {
            String rest = llDecryptCon(lanlinginput,selectedIndex);
            llDecryptInput.setText(rest);
        }
    }

    //致远解密实现
    @FXML
    private TextArea zyDecrypt1;
    @FXML
    private Button zyDecryptButton1;
    @FXML
    private TextArea zyDecryptInput1;
    @FXML
    void zyDecryptButtonAction(ActionEvent event) throws Exception {
        String input_text = zyDecrypt1.getText();
        if (input_text.length() < 2){
            zyDecryptInput1.setText(" [-] 输入错误！");
        }else {
            String zyDecryptRes = SeeyouDecode.zyDecrypt(input_text);
            zyDecryptInput1.setText(zyDecryptRes);

        }
    }

    //帆软解密实现
    @FXML
    private TextArea frDecrypt;
    @FXML
    private Button frDecryptButton;
    @FXML
    private TextArea frDecryptInput;
    @FXML
    void frDecryptButtonAction(ActionEvent event) throws Exception {
        String input_text = frDecrypt.getText();
        if (input_text.length() < 2){
            frDecryptInput.setText(" [-] 输入错误！");
        }else {
            String frRest = FineReportDecode.frDecrypt(input_text);
            frDecryptInput.setText(frRest);
        }
    }

    //用友功能实现
    @FXML
    private TextArea yyDecrypt;
    @FXML
    private Button yyDecryptButton;
    @FXML
    private TextArea yyDecryptInput;
    @FXML
    void yyDecryptButtonAction(ActionEvent event) throws Exception {
        String input_text = yyDecrypt.getText();
        if (input_text.length() < 2){
            yyDecryptInput.setText(" [-] 输入错误！");
        }else {
            String yyRest = YonyouDecode.Decode(input_text);
            yyDecryptInput.setText(yyRest);
        }

    }



    //关于功能实现
    @FXML
    void xmdzAction(ActionEvent event) {
        try {
            String url = "https://www.baidu.com";
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void xmjsAction(ActionEvent event) {
        String style = "-fx-font-family: STKaiti; -fx-font-size: 14px;";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("简介");
        alert.setHeaderText(null);
        alert.getDialogPane().lookup(".content.label").setStyle(style);
        alert.setContentText("将常见OA系统的解密方式进行缝合，优化部分算法。工具的默认密钥采用硬编码，不要过度依赖工具！");
        alert.showAndWait();
    }
}