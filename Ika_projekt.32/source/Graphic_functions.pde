/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Graphic functions file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//-------------------------------------------------------------------------------------------------------------------
//Exit function
//-------------------------------------------------------------------------------------------------------------------

public void Exit()
{
  exit();
}


//-------------------------------------------------------------------------------------------------------------------
//Links functions
//-------------------------------------------------------------------------------------------------------------------

public void link_ig()
{
  link("http://www.google.com");
}

public void link_off()
{
  link("http://www.google.com");
}

public void link_hel()
{
  link("http://www.google.com");
}

public void link_iw()
{
  link("http://www.google.com");
}

//-------------------------------------------------------------------------------------------------------------------
//Generate function
//-------------------------------------------------------------------------------------------------------------------

public void Generate_config()
{
  q_t_gav = int(cp5.get(Textfield.class,"tf_t_gav").getText());
  q_t_pha = int(cp5.get(Textfield.class,"tf_t_pha").getText());
  q_t_epe = int(cp5.get(Textfield.class,"tf_t_epe").getText());
  q_t_lan = int(cp5.get(Textfield.class,"tf_t_lan").getText());
  q_t_tir = int(cp5.get(Textfield.class,"tf_t_tir").getText());
  q_t_arc = int(cp5.get(Textfield.class,"tf_t_arc").getText());
  q_t_lpi = int(cp5.get(Textfield.class,"tf_t_lpi").getText());
  q_t_bel = int(cp5.get(Textfield.class,"tf_t_bel").getText());
  q_t_cat = int(cp5.get(Textfield.class,"tf_t_cat").getText());
  q_t_mor = int(cp5.get(Textfield.class,"tf_t_mor").getText());
  q_t_gyr = int(cp5.get(Textfield.class,"tf_t_gyr").getText());
  q_t_bbm = int(cp5.get(Textfield.class,"tf_t_bbm").getText());
  q_t_med = int(cp5.get(Textfield.class,"tf_t_med").getText());
  q_t_cui = int(cp5.get(Textfield.class,"tf_t_cui").getText());
  
  q_n_bav = int(cp5.get(Textfield.class,"tf_n_bav").getText());
  q_n_lfl = int(cp5.get(Textfield.class,"tf_n_lfl").getText());
  q_n_bel = int(cp5.get(Textfield.class,"tf_n_bel").getText());
  q_n_bal = int(cp5.get(Textfield.class,"tf_n_bal").getText());
  q_n_sma = int(cp5.get(Textfield.class,"tf_n_sma").getText());
  q_n_blm = int(cp5.get(Textfield.class,"tf_n_blm").getText());
  q_n_pbb = int(cp5.get(Textfield.class,"tf_n_pbb").getText());
  q_n_bra = int(cp5.get(Textfield.class,"tf_n_bra").getText());
  q_n_cat = int(cp5.get(Textfield.class,"tf_n_cat").getText());
  q_n_mor = int(cp5.get(Textfield.class,"tf_n_mor").getText());
  q_n_sup = int(cp5.get(Textfield.class,"tf_n_sup").getText());
  
  pg_calc();
  
  if(pg_t != 0)
    cp5.get(Textarea.class,"ta_pg_t").setText(str(pg_t));
  if(pg_n != 0)
    cp5.get(Textarea.class,"ta_pg_n").setText(str(pg_n));
  if(capa_t_total != 0)
    cp5.get(Textarea.class,"capa_t_total").setText(str(ceil(capa_t_total/500)));
  if(pop_total != 0)
    cp5.get(Textarea.class,"pop_total").setText(str(pop_total));
  if(b_total != 0)
    cp5.get(Textarea.class,"b_total").setText(str(b_total));
  if(s_total != 0)
    cp5.get(Textarea.class,"s_total").setText(str(s_total));
  if(c_total != 0)
    cp5.get(Textarea.class,"c_total").setText(str(c_total));
  if(v_total != 0)
    cp5.get(Textarea.class,"v_total").setText(str(v_total));
  if(cout_t+cout_n != 0)
    cp5.get(Textarea.class,"cout_total").setText(str(cout_t+cout_n));
}


//-------------------------------------------------------------------------------------------------------------------
//Save function
//-------------------------------------------------------------------------------------------------------------------

public void Save_config()
{
  if(flag_config_loaded)
  {
    fileToSave(ConfigFile);
  }
  else
  {
    println("No configuration loaded");
  }
}


//-------------------------------------------------------------------------------------------------------------------
//Save as function
//-------------------------------------------------------------------------------------------------------------------

public void SaveAs_config()
{
  selectInput("Select a file to save the config:", "fileToSave");
}

public void fileToSave(File selection)
{
  if(selection == null)
  {
    println("Window was closed or the user hit cancel");
  }
  else
  {
    config_file = createWriter(selection.getAbsolutePath());
    config_file.println("T&N file");
    config_file.println("date: " + date());
    config_file.println("time: " + time());
    config_file.println("");
    config_file.println("--T");
    config_file.println("$gav = " + cp5.get(Textfield.class,"tf_t_gav").getText());
    config_file.println("$pha = " + cp5.get(Textfield.class,"tf_t_pha").getText());
    config_file.println("$epe = " + cp5.get(Textfield.class,"tf_t_epe").getText());
    config_file.println("$lan = " + cp5.get(Textfield.class,"tf_t_lan").getText());
    config_file.println("$tir = " + cp5.get(Textfield.class,"tf_t_tir").getText());
    config_file.println("$lpi = " + cp5.get(Textfield.class,"tf_t_lpi").getText());
    config_file.println("$arc = " + cp5.get(Textfield.class,"tf_t_arc").getText());
    config_file.println("$bel = " + cp5.get(Textfield.class,"tf_t_bel").getText());
    config_file.println("$cat = " + cp5.get(Textfield.class,"tf_t_cat").getText());
    config_file.println("$mor = " + cp5.get(Textfield.class,"tf_t_mor").getText());
    config_file.println("$gyr = " + cp5.get(Textfield.class,"tf_t_gyr").getText());
    config_file.println("$bbm = " + cp5.get(Textfield.class,"tf_t_bbm").getText());
    config_file.println("$med = " + cp5.get(Textfield.class,"tf_t_med").getText());
    config_file.println("$cui = " + cp5.get(Textfield.class,"tf_t_cui").getText());
    config_file.println("");
    config_file.println("--N");
    config_file.println("$lfl = " + cp5.get(Textfield.class,"tf_n_lfl").getText());
    config_file.println("$bav = " + cp5.get(Textfield.class,"tf_n_bav").getText());
    config_file.println("$bel = " + cp5.get(Textfield.class,"tf_n_bel").getText());
    config_file.println("$bal = " + cp5.get(Textfield.class,"tf_n_bal").getText());
    config_file.println("$blm = " + cp5.get(Textfield.class,"tf_n_blm").getText());
    config_file.println("$sma = " + cp5.get(Textfield.class,"tf_n_sma").getText());
    config_file.println("$cat = " + cp5.get(Textfield.class,"tf_n_cat").getText());
    config_file.println("$mor = " + cp5.get(Textfield.class,"tf_n_mor").getText());
    config_file.println("$bra = " + cp5.get(Textfield.class,"tf_n_bra").getText());
    config_file.println("$pbb = " + cp5.get(Textfield.class,"tf_n_pbb").getText());
    config_file.println("$sup = " + cp5.get(Textfield.class,"tf_n_sup").getText());
    
    config_file.flush();
    config_file.close();
  }
}


//-------------------------------------------------------------------------------------------------------------------
//Load_config function
//-------------------------------------------------------------------------------------------------------------------

public void Load_config()
{
  selectInput("Select a configuration file to load:", "ConfigFileLoaded");
}

public void ConfigFileLoaded(File selection)
{
  if(selection == null)
  {
    println("Window was closed or the user hit cancel");
  }
  else
  {
    line = 0;
    println("User selected " + selection.getAbsolutePath());
    ConfigFile = selection;
    flag_config_loaded = true;
    config_loaded = loadStrings(ConfigFile);
    config_reader();
  }
}


//-------------------------------------------------------------------------------------------------------------------
//Minimize window function
//-------------------------------------------------------------------------------------------------------------------

public void minimizeWindow()
{
  frame.setState(Frame.ICONIFIED);
}
