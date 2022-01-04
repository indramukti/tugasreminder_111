/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaB.tugas_reminder;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dell
 */
@Controller
public class controlerjavaBtugas_reminder {

    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model discountprocess){

        String inputname = data.getParameter("var_name");

        String inputprice = data.getParameter("var_price");

        String inputquantity = data.getParameter("var_quantity");

        String diskon = "";

        Double iPrice = Double.valueOf(inputprice);
        Double iTotal = Double.valueOf(inputquantity);
        Double PriceTotal = iPrice * iTotal;
        Double getTotal = null;

        if (PriceTotal < 16000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
        }
        else if (PriceTotal >= 16000 && PriceTotal < 25000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskon = "15%";
        }
        else if (PriceTotal >= 25000)
        {
            getTotal = PriceTotal - (20 * PriceTotal/100);
            diskon = "20%";
        }

        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("total", getTotal);
        discountprocess.addAttribute("diskon", diskon);

        return "view";
    }
}
