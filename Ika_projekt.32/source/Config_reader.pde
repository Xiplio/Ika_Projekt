/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Reads the loaded config file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
int line = 0;

public void config_reader()
{

  while (line < config_loaded.length)
  {
    if (config_loaded[line].indexOf("--T")>=0)
    {
      println("Flag T");
      flag_t = true;
      flag_n = false;
    } else if (config_loaded[line].indexOf("--N")>=0)
    {
      println("Flag N");
      flag_n = true;
      flag_t = false;
    }

    if (flag_t)
    {
      if (config_loaded[line].indexOf("$gav")>=0)
      {
        println("gav : " + config_loaded[line].substring(config_loaded[line].indexOf("$gav")+7));
        cp5.get(Textfield.class, "tf_t_gav").setText(config_loaded[line].substring(config_loaded[line].indexOf("$gav")+7));
      } else if (config_loaded[line].indexOf("$pha")>=0)
      {
        println("pha : " + config_loaded[line].substring(config_loaded[line].indexOf("$pha")+7));
        cp5.get(Textfield.class, "tf_t_pha").setText(config_loaded[line].substring(config_loaded[line].indexOf("$pha")+7));
      } else if (config_loaded[line].indexOf("$lan")>=0)
      {
        println("lan : " + config_loaded[line].substring(config_loaded[line].indexOf("$lan")+7));
        cp5.get(Textfield.class, "tf_t_lan").setText(config_loaded[line].substring(config_loaded[line].indexOf("$lan")+7));
      } else if (config_loaded[line].indexOf("$epe")>=0)
      {
        println("epe : " + config_loaded[line].substring(config_loaded[line].indexOf("$epe")+7));
        cp5.get(Textfield.class, "tf_t_epe").setText(config_loaded[line].substring(config_loaded[line].indexOf("$epe")+7));
      } else if (config_loaded[line].indexOf("$tir")>=0)
      {
        println("tir : " + config_loaded[line].substring(config_loaded[line].indexOf("$tir")+7));
        cp5.get(Textfield.class, "tf_t_tir").setText(config_loaded[line].substring(config_loaded[line].indexOf("$tir")+7));
      } else if (config_loaded[line].indexOf("$arc")>=0)
      {
        println("arc : " + config_loaded[line].substring(config_loaded[line].indexOf("$arc")+7));
        cp5.get(Textfield.class, "tf_t_arc").setText(config_loaded[line].substring(config_loaded[line].indexOf("$arc")+7));
      } else if (config_loaded[line].indexOf("$lpi")>=0)
      {
        println("lpi : " + config_loaded[line].substring(config_loaded[line].indexOf("$lpi")+7));
        cp5.get(Textfield.class, "tf_t_lpi").setText(config_loaded[line].substring(config_loaded[line].indexOf("$lpi")+7));
      } else if (config_loaded[line].indexOf("$bel")>=0)
      {
        println("bel : " + config_loaded[line].substring(config_loaded[line].indexOf("$bel")+7));
        cp5.get(Textfield.class, "tf_t_bel").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bel")+7));
      } else if (config_loaded[line].indexOf("$cat")>=0)
      {
        println("cat : " + config_loaded[line].substring(config_loaded[line].indexOf("$cat")+7));
        cp5.get(Textfield.class, "tf_t_cat").setText(config_loaded[line].substring(config_loaded[line].indexOf("$cat")+7));
      } else if (config_loaded[line].indexOf("$mor")>=0)
      {
        println("mor : " + config_loaded[line].substring(config_loaded[line].indexOf("$mor")+7));
        cp5.get(Textfield.class, "tf_t_mor").setText(config_loaded[line].substring(config_loaded[line].indexOf("$mor")+7));
      } else if (config_loaded[line].indexOf("$gyr")>=0)
      {
        println("gyr : " + config_loaded[line].substring(config_loaded[line].indexOf("$gyr")+7));
        cp5.get(Textfield.class, "tf_t_gyr").setText(config_loaded[line].substring(config_loaded[line].indexOf("$gyr")+7));
      } else if (config_loaded[line].indexOf("$bbm")>=0)
      {
        println("bbm : " + config_loaded[line].substring(config_loaded[line].indexOf("$bbm")+7));
        cp5.get(Textfield.class, "tf_t_bbm").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bbm")+7));
      } else if (config_loaded[line].indexOf("$med")>=0)
      {
        println("med : " + config_loaded[line].substring(config_loaded[line].indexOf("$med")+7));
        cp5.get(Textfield.class, "tf_t_med").setText(config_loaded[line].substring(config_loaded[line].indexOf("$med")+7));
      } else if (config_loaded[line].indexOf("$cui")>=0)
      {
        println("cui : " + config_loaded[line].substring(config_loaded[line].indexOf("$cui")+7));
        cp5.get(Textfield.class, "tf_t_cui").setText(config_loaded[line].substring(config_loaded[line].indexOf("$cui")+7));
      }
    }

    if (flag_n)
    {
      if (config_loaded[line].indexOf("$bav")>=0)
      {
        println("bav : " + config_loaded[line].substring(config_loaded[line].indexOf("$bav")+7));
        cp5.get(Textfield.class, "tf_n_bav").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bav")+7));
      } else if (config_loaded[line].indexOf("$lfl")>=0)
      {
        println("lfl : " + config_loaded[line].substring(config_loaded[line].indexOf("$lfl")+7));
        cp5.get(Textfield.class, "tf_n_lfl").setText(config_loaded[line].substring(config_loaded[line].indexOf("$lfl")+7));
      } else if (config_loaded[line].indexOf("$bel")>=0)
      {
        println("bel : " + config_loaded[line].substring(config_loaded[line].indexOf("$bel")+7));
        cp5.get(Textfield.class, "tf_n_bel").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bel")+7));
      } else if (config_loaded[line].indexOf("$bal")>=0)
      {
        println("bal : " + config_loaded[line].substring(config_loaded[line].indexOf("$bal")+7));
        cp5.get(Textfield.class, "tf_n_bal").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bal")+7));
      } else if (config_loaded[line].indexOf("$cat")>=0)
      {
        println("cat : " + config_loaded[line].substring(config_loaded[line].indexOf("$cat")+7));
        cp5.get(Textfield.class, "tf_n_cat").setText(config_loaded[line].substring(config_loaded[line].indexOf("$cat")+7));
      } else if (config_loaded[line].indexOf("$mor")>=0)
      {
        println("mor : " + config_loaded[line].substring(config_loaded[line].indexOf("$mor")+7));
        cp5.get(Textfield.class, "tf_n_mor").setText(config_loaded[line].substring(config_loaded[line].indexOf("$mor")+7));
      } else if (config_loaded[line].indexOf("$sma")>=0)
      {
        println("sma : " + config_loaded[line].substring(config_loaded[line].indexOf("$sma")+7));
        cp5.get(Textfield.class, "tf_n_sma").setText(config_loaded[line].substring(config_loaded[line].indexOf("$sma")+7));
      } else if (config_loaded[line].indexOf("$blm")>=0)
      {
        println("bel : " + config_loaded[line].substring(config_loaded[line].indexOf("$blm")+7));
        cp5.get(Textfield.class, "tf_n_blm").setText(config_loaded[line].substring(config_loaded[line].indexOf("$blm")+7));
      } else if (config_loaded[line].indexOf("$pbb")>=0)
      {
        println("pbb : " + config_loaded[line].substring(config_loaded[line].indexOf("$pbb")+7));
        cp5.get(Textfield.class, "tf_n_pbb").setText(config_loaded[line].substring(config_loaded[line].indexOf("$pbb")+7));
      } else if (config_loaded[line].indexOf("$bra")>=0)
      {
        println("bra : " + config_loaded[line].substring(config_loaded[line].indexOf("$bra")+7));
        cp5.get(Textfield.class, "tf_n_bra").setText(config_loaded[line].substring(config_loaded[line].indexOf("$bra")+7));
      } else if (config_loaded[line].indexOf("$sup")>=0)
      {
        println("sup : " + config_loaded[line].substring(config_loaded[line].indexOf("$sup")+7));
        cp5.get(Textfield.class, "tf_n_sup").setText(config_loaded[line].substring(config_loaded[line].indexOf("$sup")+7));
      }
    }
    line++;
  }
}

