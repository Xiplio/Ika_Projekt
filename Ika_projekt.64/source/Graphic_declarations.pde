/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Graphic declarations file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public void graphic()
{
  cp5.addTab("ter")
    .setColorBackground(COLOR_IKA)
      .setColorForeground(color(200))
        .setColorActive(color(100))
          .setHeight(25)
            .setWidth(150)
              .setLabel("Terrestre")
                .getCaptionLabel().align(CENTER, CENTER).setFont(createFont("Calibri",14))
                  .setColor(color(50));  
  
  cp5.addTab("nav")
    .setColorBackground(COLOR_IKA)
      .setColorForeground(color(200))
        .setColorActive(color(100))
          .setHeight(25)
            .setWidth(150)
              .setLabel("Naval")
                .getCaptionLabel().align(CENTER, CENTER).setFont(createFont("Calibri",14))
                  .setColor(color(50)); 
  
  cp5.getTab("default")
    .setColorBackground(color(COLOR_IKA))
      .setColorForeground(color(200))
        .setColorActive(color(100))
          .setLabel("Accueil")
            .setHeight(25)
              .setWidth(150)
                .getCaptionLabel().align(CENTER, CENTER).setFont(createFont("Calibri",14))
                  .setColor(50);
                  
  mButton Exit = new mButton("Exit", "X", 1415, 0, 25, 25, COLOR_BUTTON, "global");
  mButton Load_config = new mButton("Load_config", "Charger config", 20, 30, 120, 30, COLOR_BUTTON, "global");
  mButton Generate_config = new mButton("Generate_config", "Générer config", 150, 30, 120, 30, COLOR_BUTTON, "global");
  mButton Save_config = new mButton("Save_config", "Sauvegarder", 280, 30, 120, 30, COLOR_BUTTON, "global");
  mButton SaveAs_config = new mButton("SaveAs_config", "Sauvegarder sous", 410, 30, 120, 30, COLOR_BUTTON, "global");
  
  mButton link_ig = new mButton("link_ig", "link_ig", 570, 200, 300, 150, color(0), "default");
  cp5.getController("link_ig").setImage(img_ikariam);
  mButton link_hel = new mButton("link_hel", "link_hel", 980, 200, 300, 150, color(0), "default");
  cp5.getController("link_hel").setImage(img_forum_hell);
  mButton link_iw = new mButton("link_iw", "link_iw", 570, 450, 300, 150, color(0), "default");
  cp5.getController("link_iw").setImage(img_ikaworld);
  mButton link_off = new mButton("link_off", "link_off", 980, 450, 300, 150, color(0), "default");
  cp5.getController("link_off").setImage(img_forum_off);
  
  mButton moveWindow = new mButton("moveWindow", "", 462, 0, 1440-462-52,25,color(0),"global");
  cp5.getController("moveWindow").setColorBackground(COLOR_IKA);
  cp5.getController("moveWindow").setColorForeground(COLOR_IKA);
  cp5.getController("moveWindow").setColorActive(COLOR_IKA);
  mButton minimizeWindow = new mButton("minimizeWindow", "-", 1440-51, 0, 25,25,color(0),"global");
  cp5.getController("minimizeWindow").getCaptionLabel().setFont(createFont("Calibri",20)).setColor(0);
  cp5.getController("minimizeWindow").setColorBackground(COLOR_IKA);
  
  
  mTextfield tf_t_gav = new mTextfield("tf_t_gav", "gav", 520, 250, 100, 30, "ter");
  mTextfield tf_t_pha = new mTextfield("tf_t_pha", "pha", 700, 250, 100, 30, "ter");
  mTextfield tf_t_epe = new mTextfield("tf_t_epe", "epe", 880, 250, 100, 30, "ter");
  mTextfield tf_t_lan = new mTextfield("tf_t_lan", "lan", 1060,250, 100, 30, "ter");
  mTextfield tf_t_tir = new mTextfield("tf_t_tir", "tir", 1240,250, 100, 30, "ter");
  mTextfield tf_t_lpi = new mTextfield("tf_t_lpi", "lpi", 520, 450, 100, 30, "ter");
  mTextfield tf_t_arc = new mTextfield("tf_t_arc", "arc", 700, 450, 100, 30, "ter");
  mTextfield tf_t_bel = new mTextfield("tf_t_bel", "bel", 880, 450, 100, 30, "ter");
  mTextfield tf_t_cat = new mTextfield("tf_t_cat", "cat", 1060,450, 100, 30, "ter");
  mTextfield tf_t_mor = new mTextfield("tf_t_mor", "mor", 1240,450, 100, 30, "ter");
  mTextfield tf_t_gyr = new mTextfield("tf_t_gyr", "gyr", 610, 650, 100, 30, "ter");
  mTextfield tf_t_bbm = new mTextfield("tf_t_bbm", "bbm", 790, 650, 100, 30, "ter");
  mTextfield tf_t_med = new mTextfield("tf_t_med", "med", 970, 650, 100, 30, "ter");
  mTextfield tf_t_cui = new mTextfield("tf_t_cui", "cui", 1150,650, 100, 30, "ter");
  
  mTextfield tf_n_lfl = new mTextfield("tf_n_lfl", "lfl", 610, 250, 100, 30, "nav");
  mTextfield tf_n_bav = new mTextfield("tf_n_bav", "bav", 790, 250, 100, 30, "nav");
  mTextfield tf_n_blm = new mTextfield("tf_n_blm", "blm", 970, 250, 100, 30, "nav");
  mTextfield tf_n_sma = new mTextfield("tf_n_sma", "sma", 1150,250, 100, 30, "nav");
  mTextfield tf_n_bel = new mTextfield("tf_n_bel", "bel", 610, 450, 100, 30, "nav");
  mTextfield tf_n_bal = new mTextfield("tf_n_bal", "bal", 790, 450, 100, 30, "nav");
  mTextfield tf_n_cat = new mTextfield("tf_n_cat", "cat", 970, 450, 100, 30, "nav");
  mTextfield tf_n_mor = new mTextfield("tf_n_mor", "mor", 1150,450, 100, 30, "nav");
  mTextfield tf_n_bra = new mTextfield("tf_n_bra", "bra", 720, 650, 100, 30, "nav");
  mTextfield tf_n_pba = new mTextfield("tf_n_pbb", "pbb", 900, 650, 100, 30, "nav");
  mTextfield tf_n_sup = new mTextfield("tf_n_sup", "sup", 1080,650, 100, 30, "nav");

  mTextfield tf_red_t = new mTextfield("tf_red_t", "% terrestre", 700, 30, 100, 30, "global"); 
  cp5.getController("tf_red_t").setLabel("% terrestre");
  cp5.getController("tf_red_t").getCaptionLabel().setPadding(-80,-22);
  cp5.get(Textfield.class,"tf_red_t").setText("0");
  mTextfield tf_red_n = new mTextfield("tf_red_n", "% naval"    , 880, 30, 100, 30, "global");
  cp5.getController("tf_red_n").setLabel("% naval");
  cp5.get(Textfield.class,"tf_red_n").setText("0");
  cp5.getController("tf_red_n").getCaptionLabel().setPadding(-57,-22);
  
  mTextarea ta_pg_t      = new mTextarea("ta_pg_t"     , "", 170, 265, 100, 30, "global");
  mTextarea ta_pg_n      = new mTextarea("ta_pg_n"     , "", 170, 365, 100, 30, "global");
  mTextarea capa_t_total = new mTextarea("capa_t_total", "", 170, 465, 100, 30, "global");
  mTextarea pop_total    = new mTextarea("pop_total"   , "", 170, 165, 100, 30, "global");
  mTextarea b_total      = new mTextarea("b_total"     , "", 170, 560, 100, 30, "global");
  mTextarea s_total      = new mTextarea("s_total"     , "", 170, 590, 100, 30, "global");
  mTextarea c_total      = new mTextarea("c_total"     , "", 170, 620, 100, 30, "global");
  mTextarea v_total      = new mTextarea("v_total"     , "", 170, 650, 100, 30, "global");
  mTextarea cout_total   = new mTextarea("cout_total"  , "", 170, 720, 100, 30, "global");
}
