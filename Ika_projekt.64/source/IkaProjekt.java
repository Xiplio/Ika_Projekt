import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 
import java.awt.event.KeyEvent; 
import java.awt.MouseInfo; 
import java.awt.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class IkaProjekt extends PApplet {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Main file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//v1.0 :
//- pg calc
//- res calc
//- carrying calc
//- pop calc
//- save/load config
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//AF: select language
//AF: moving stuff
//AF: resize stuff
//AF: rectangles d'aide
//AF: rectangles autour des liens quand survol\u00e9s
//AF: r\u00e9glage des r\u00e9ductions de co\u00fbt selon les recherches
//AF: simulation sur diff\u00e9rentes dur\u00e9es
//AF: mise \u00e0 jour automatique au fur et \u00e0 mesure des changements
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//-------------------------------------------------------------------------------------------------------------------
//Importations
//-------------------------------------------------------------------------------------------------------------------







//-------------------------------------------------------------------------------------------------------------------
//Declarations
//-------------------------------------------------------------------------------------------------------------------

final int COLOR_BCKG = color(240)  ;
final int COLOR_BUTTON = color(250,234,198);
final int COLOR_IKA = color(250,234,198);
final int COLOR_IKA0 = color(253,247,221);

final float b_t_gav = 130, s_t_gav = 180 , h_t_gav = 12, capa_t_gav = 15, pg_t_gav = 6.2f , pop_t_gav = 2;
final float b_t_pha = 40 , s_t_pha = 30  , h_t_pha = 3 , capa_t_pha = 5 , pg_t_pha = 1.4f , pop_t_pha = 1;
final float b_t_epe = 30 , s_t_epe = 30  , h_t_epe = 4 , capa_t_epe = 3 , pg_t_epe = 1.2f , pop_t_epe = 1;
final float b_t_lan = 30 , s_t_lan = 0   , h_t_lan = 1 , capa_t_lan = 3 , pg_t_lan = 0.6f , pop_t_lan = 1;
final float b_t_tir = 50 , s_t_tir = 150 , h_t_tir = 3 , capa_t_tir = 5 , pg_t_tir = 4   , pop_t_tir = 1;
final float b_t_lpi = 20 , s_t_lpi = 0   , h_t_lpi = 2 , capa_t_lpi = 3 , pg_t_lpi = 0.4f , pop_t_lpi = 1;
final float b_t_arc = 30 , s_t_arc = 25  , h_t_arc = 4 , capa_t_arc = 5 , pg_t_arc = 1.1f , pop_t_arc = 1;
final float b_t_bel = 220, s_t_bel = 0   , h_t_bel = 15, capa_t_bel = 30, pg_t_bel = 4.4f , pop_t_bel = 5;
final float b_t_cat = 260, s_t_cat = 300 , h_t_cat = 25, capa_t_cat = 30, pg_t_cat = 11.2f, pop_t_cat = 5;
final float b_t_mor = 300, s_t_mor = 1250, h_t_mor = 30, capa_t_mor = 30, pg_t_mor = 31  , pop_t_mor = 5;
final float b_t_gyr = 25 , s_t_gyr = 100 , h_t_gyr = 15, capa_t_gyr = 15, pg_t_gyr = 2.5f , pop_t_gyr = 3;
final float b_t_bbm = 40 , s_t_bbm = 250 , h_t_bbm = 45, capa_t_bbm = 30, pg_t_bbm = 5.8f , pop_t_bbm = 5;
final float b_t_med = 50 , c_t_med = 450 , h_t_med = 20, capa_t_med = 10, pg_t_med = 10  , pop_t_med = 1;
final float b_t_cui = 50 , v_t_cui = 150 , h_t_cui = 10, capa_t_cui = 20, pg_t_cui = 4   , pop_t_cui = 1;

final float b_n_lfl = 80 , s_n_lfl = 230 ,                h_n_lfl = 25 , pg_n_lfl = 6.2f , pop_n_lfl = 4;
final float b_n_bav = 400, s_n_bav = 800 ,                h_n_bav = 45 , pg_n_bav = 24  , pop_n_bav = 2;
final float b_n_bel = 250, s_n_bel = 0   ,                h_n_bel = 15 , pg_n_bel = 5   , pop_n_bel = 3;
final float b_n_bal = 180, s_n_bal = 160 ,                h_n_bal = 20 , pg_n_bal = 6.8f , pop_n_bal = 6;
final float b_n_blm = 200, s_n_blm = 1200,                h_n_blm = 55 , pg_n_blm = 28  , pop_n_blm = 2;
final float b_n_sma = 160, s_n_sma = 100 , c_n_sma = 750, h_n_sma = 50 , pg_n_sma = 20.2f, pop_n_sma = 3;
final float b_n_cat = 180, s_n_cat = 140 ,                h_n_cat = 35 , pg_n_cat = 6.4f , pop_n_cat = 5;
final float b_n_mor = 220, s_n_mor = 900 ,                h_n_mor = 50 , pg_n_mor = 22.4f, pop_n_mor = 5;
final float b_n_bra = 40 , s_n_bra = 280 ,                h_n_bra = 5  , pg_n_bra = 6.4f , pop_n_bra = 1;
final float b_n_pbb = 700, s_n_pbb = 700 ,                h_n_pbb = 100, pg_n_pbb = 28  , pop_n_pbb = 8;
final float b_n_sup = 300, s_n_sup = 250 , c_n_sup = 250, h_n_sup = 100, pg_n_sup = 16  , pop_n_sup = 7;

int q_t_gav = 0,
    q_t_pha = 0,
    q_t_epe = 0,
    q_t_lan = 0,
    q_t_tir = 0,
    q_t_lpi = 0,
    q_t_arc = 0,
    q_t_bel = 0,
    q_t_cat = 0,
    q_t_mor = 0,
    q_t_gyr = 0,
    q_t_bbm = 0,
    q_t_med = 0,
    q_t_cui = 0,
    q_n_lfl = 0,
    q_n_bav = 0,
    q_n_bel = 0,
    q_n_bal = 0,
    q_n_blm = 0,
    q_n_sma = 0,
    q_n_cat = 0,
    q_n_mor = 0,
    q_n_bra = 0,
    q_n_pbb = 0,
    q_n_sup = 0;
int fps;
int b_total, c_total, v_total, s_total,
    capa_t_total,
    pop_total,
    cout_t,cout_n, cout_total;

float pg_t, pg_n;

PImage img_t_gav,
       img_t_pha,
       img_t_epe,
       img_t_lan,
       img_t_tir,
       img_t_lpi,
       img_t_arc,
       img_t_bel,
       img_t_cat,
       img_t_mor,
       img_t_gyr,
       img_t_bbm,
       img_t_med,
       img_t_cui,
       img_n_lfl,
       img_n_bav,
       img_n_bel,
       img_n_bal,
       img_n_blm,
       img_n_sma,
       img_n_cat,
       img_n_mor,
       img_n_bra,
       img_n_pbb,
       img_n_sup,
       img_pop,
       img_pgt,
       img_pgn,
       img_marchand,
       img_resources;
PImage img_forum_hell,
       img_forum_off,
       img_ikariam,
       img_ikaworld,
       img_ikaprojekt,
       img_or;
       
boolean flag_first_draw = false;
boolean flag_wait = false      ;
boolean flag_t = false         ;
boolean flag_n = false         ;

PrintWriter config_file;
float timer;
boolean flag_config_loaded = false;
boolean flag_window = false;
String config_loaded[];
String time, date;

File ConfigFile;
ControlP5 cp5;


//-------------------------------------------------------------------------------------------------------------------
//Setup
//-------------------------------------------------------------------------------------------------------------------

public void setup()
{  
  size(400,200)             ;
  frame.removeNotify()      ;
  frame.setUndecorated(true);
  frame.addNotify()         ;
  frame.setResizable(true)  ;

  cp5 = new ControlP5(this);

  timer = millis();
  frameRate(50);
  
  windowX = displayWidth/2-width/2;
  windowY = displayHeight/2-height/2;
  
  img_t_gav = loadImage("img_gav.png");
  img_t_pha = loadImage("img_pha.png");
  img_t_epe = loadImage("img_epe.png");
  img_t_lan = loadImage("img_lan.png");
  img_t_arc = loadImage("img_arc.png");
  img_t_tir = loadImage("img_tir.png");
  img_t_lpi = loadImage("img_lpi.png");
  img_t_bel = loadImage("img_bel.png");
  img_t_cat = loadImage("img_cat.png");
  img_t_mor = loadImage("img_mor.png");
  img_t_bbm = loadImage("img_bbm.png");
  img_t_gyr = loadImage("img_gyr.png");
  img_t_med = loadImage("img_med.png");
  img_t_cui = loadImage("img_cui.png");
  
  img_n_lfl = loadImage("img_lfl.png");
  img_n_bav = loadImage("img_bav.png");
  img_n_bel = loadImage("img_bel2.png");
  img_n_bal = loadImage("img_bal.png");
  img_n_cat = loadImage("img_cat2.png");
  img_n_mor = loadImage("img_mor2.png");
  img_n_sma = loadImage("img_sma.png");
  img_n_blm = loadImage("img_blm.png");
  img_n_bra = loadImage("img_bra.png");
  img_n_pbb = loadImage("img_pbb.png");
  img_n_sup = loadImage("img_sup.png");
  
  img_pop = loadImage("img_pop.png");
  img_pgt = loadImage("img_pgt.png");
  img_pgn = loadImage("img_pgn.png");
  img_resources = loadImage("img_resources.png");
  img_marchand = loadImage("img_marchand.png");
  img_or = loadImage("img_or0.png");
  
  img_forum_hell = loadImage("helheim_forum.png");
  img_ikariam = loadImage("img_ikariam.png");
  img_forum_off = loadImage("img_forum_off.png");
  img_ikaworld = loadImage("img_ikaworld.png");
  
  img_ikaprojekt = loadImage("img_ikaproject.png");
  
//  img_logo = loadImage("icon-72.png");
//
//  //Icon settings
//  final PGraphics pg = createGraphics(3000, 3000, JAVA2D);
//  pg.beginDraw();
//  pg.image(img_logo, 0, 0, 3000, 3000);
//  pg.endDraw();
//  frame.setIconImage(pg.image);
}


//-------------------------------------------------------------------------------------------------------------------
//Draw
//-------------------------------------------------------------------------------------------------------------------

public void draw()
{
  strokeWeight(1);
  frame.setLocation(windowX, windowY);
    background(COLOR_IKA);

  if(!flag_first_draw)
    init_function();
  else if(flag_first_draw)
  {
    lines();
    if(cp5.getTab("ter").isActive())
    {
      image(img_t_gav,540,180);
      image(img_t_pha,720,180);
      image(img_t_epe,900,180);
      image(img_t_lan,1080,180);
      image(img_t_tir,1260,180);
      image(img_t_arc,720,380);
      image(img_t_lpi,540,380);
      image(img_t_bel,900,380);
      image(img_t_cat,1080,380);
      image(img_t_mor,1260,380);
      image(img_t_bbm,630,580);
      image(img_t_gyr,810,580);
      image(img_t_med,990,580);
      image(img_t_cui,1170,580);   
    }
    else if(cp5.getTab("nav").isActive())
    {
      image(img_n_lfl,630,180);
      image(img_n_bav,810,180);
      image(img_n_blm,990,180);
      image(img_n_sma,1170,180);
      image(img_n_bel,630,380);
      image(img_n_bal,810,380);
      image(img_n_cat,990,380);
      image(img_n_mor,1170,380);
      image(img_n_bra,740,580);
      image(img_n_pbb,920,580);
      image(img_n_sup,1100,580);
    }
    image(img_pop,100,150);
    image(img_pgt,100,250);
    image(img_pgn,100,350);
    image(img_resources,100,550);
    image(img_marchand,100,450,55,60);
    image(img_or,100,700);
    
    graphicUpdate();
    
    fill(0);
    if (frameCount%25==0)
      fps = PApplet.parseInt(frameRate);
    //text("-" + fps + "-", width-25, height-10);    
    
    text(time(),1440-55,50);
    text("v0.1",1440-30, 810-10);
    noFill();
    strokeWeight(5);
    stroke(150);
    if(cp5.getController("link_ig").isMouseOver())
      rect(569,199,301,151);
    if(cp5.getController("link_iw").isMouseOver())
      rect(569,449,301,151);
    if(cp5.getController("link_hel").isMouseOver())
      rect(979,199,301,151);  
    if(cp5.getController("link_off").isMouseOver())
      rect(979,449,301,151);
      
    window_position();
  }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Function making calculations
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public void pg_calc()
{
  pg_t = q_t_gav * pg_t_gav +
         q_t_pha * pg_t_pha +
         q_t_epe * pg_t_epe +
         q_t_lan * pg_t_lan +
         q_t_tir * pg_t_tir +
         q_t_lpi * pg_t_lpi +
         q_t_arc * pg_t_arc +
         q_t_bel * pg_t_bel +
         q_t_cat * pg_t_cat +
         q_t_mor * pg_t_mor +
         q_t_gyr * pg_t_gyr +
         q_t_bbm * pg_t_bbm +
         q_t_med * pg_t_med +
         q_t_cui * pg_t_cui;
  println("pg_t : " + pg_t);
  
  pg_n = q_n_lfl * pg_n_lfl +
         q_n_bav * pg_n_bav +
         q_n_bel * pg_n_bel +
         q_n_bal * pg_n_bal +
         q_n_blm * pg_n_blm +
         q_n_sma * pg_n_sma +
         q_n_cat * pg_n_cat +
         q_n_mor * pg_n_mor +
         q_n_bra * pg_n_bra +
         q_n_pbb * pg_n_pbb +
         q_n_sup * pg_n_sup;
  println("pg_n : " + pg_n);
  
  b_total = PApplet.parseInt(q_t_gav * b_t_gav +
            q_t_pha * b_t_pha +
            q_t_epe * b_t_epe +
            q_t_lan * b_t_lan +
            q_t_tir * b_t_tir +
            q_t_lpi * b_t_lpi +
            q_t_arc * b_t_arc +
            q_t_bel * b_t_bel +
            q_t_cat * b_t_cat +
            q_t_mor * b_t_mor +
            q_t_gyr * b_t_gyr +
            q_t_bbm * b_t_bbm +
            q_t_med * b_t_med +
            q_t_cui * b_t_cui +
            q_n_lfl * b_n_lfl +
            q_n_bav * b_n_bav +
            q_n_bel * b_n_bel +
            q_n_bal * b_n_bal +
            q_n_blm * b_n_blm +
            q_n_sma * b_n_sma +
            q_n_cat * b_n_cat +
            q_n_mor * b_n_mor +
            q_n_bra * b_n_bra +
            q_n_pbb * b_n_pbb +
            q_n_sup * b_n_sup);
  println("b_total : " + b_total);
  
  s_total = PApplet.parseInt(q_t_gav * s_t_gav +
            q_t_pha * s_t_pha +
            q_t_epe * s_t_epe +
            q_t_lan * s_t_lan +
            q_t_tir * s_t_tir +
            q_t_lpi * s_t_lpi +
            q_t_arc * s_t_arc +
            q_t_bel * s_t_bel +
            q_t_cat * s_t_cat +
            q_t_mor * s_t_mor +
            q_t_gyr * s_t_gyr +
            q_t_bbm * s_t_bbm +
            q_n_lfl * s_n_lfl +
            q_n_bav * s_n_bav +
            q_n_bel * s_n_bel +
            q_n_bal * s_n_bal +
            q_n_blm * s_n_blm +
            q_n_sma * s_n_sma +
            q_n_cat * s_n_cat +
            q_n_mor * s_n_mor +
            q_n_bra * s_n_bra +
            q_n_pbb * s_n_pbb +
            q_n_sup * s_n_sup);
  println("s_total : " + s_total);
  
  v_total = PApplet.parseInt(q_t_cui * v_t_cui);
  println("v_total : " + v_total);
  
  c_total = PApplet.parseInt(q_t_med * c_t_med +
            q_n_sma * c_n_sma +
            q_n_sup * c_n_sup);
  println("c_total : " + c_total);
  
  pop_total = PApplet.parseInt(q_t_gav * pop_t_gav +
              q_t_pha * pop_t_pha +
              q_t_epe * pop_t_epe +
              q_t_lan * pop_t_lan +
              q_t_tir * pop_t_tir +
              q_t_lpi * pop_t_lpi +
              q_t_arc * pop_t_arc +
              q_t_bel * pop_t_bel +
              q_t_cat * pop_t_cat +
              q_t_mor * pop_t_mor +
              q_t_gyr * pop_t_gyr +
              q_t_bbm * pop_t_bbm +
              q_t_med * pop_t_med +
              q_t_cui * pop_t_cui +
              q_n_lfl * pop_n_lfl +
              q_n_bav * pop_n_bav +
              q_n_bel * pop_n_bel +
              q_n_bal * pop_n_bal +
              q_n_blm * pop_n_blm +
              q_n_sma * pop_n_sma +
              q_n_cat * pop_n_cat +
              q_n_mor * pop_n_mor +
              q_n_bra * pop_n_bra +
              q_n_pbb * pop_n_pbb +
              q_n_sup * pop_n_sup);
  println("pop_total : " + pop_total);
  
  capa_t_total = PApplet.parseInt(q_t_gav * capa_t_gav +
                 q_t_pha * capa_t_pha +
                 q_t_epe * capa_t_epe +
                 q_t_lan * capa_t_lan +
                 q_t_tir * capa_t_tir +
                 q_t_lpi * capa_t_lpi +
                 q_t_arc * capa_t_arc +
                 q_t_bel * capa_t_bel +
                 q_t_cat * capa_t_cat +
                 q_t_mor * capa_t_mor +
                 q_t_gyr * capa_t_gyr +
                 q_t_bbm * capa_t_bbm +
                 q_t_med * capa_t_med +
                 q_t_cui * capa_t_cui);
  println("capa_t_total : " + capa_t_total);
  
  cout_t = PApplet.parseInt(q_t_gav * h_t_gav +
              q_t_pha * h_t_pha +
              q_t_epe * h_t_epe +
              q_t_lan * h_t_lan +
              q_t_tir * h_t_tir +
              q_t_lpi * h_t_lpi +
              q_t_arc * h_t_arc +
              q_t_bel * h_t_bel +
              q_t_cat * h_t_cat +
              q_t_mor * h_t_mor +
              q_t_gyr * h_t_gyr +
              q_t_bbm * h_t_bbm +
              q_t_med * h_t_med +
              q_t_cui * h_t_cui);
              
  cout_n = PApplet.parseInt(q_n_lfl * h_n_lfl +
              q_n_bav * h_n_bav +
              q_n_bel * h_n_bel +
              q_n_bal * h_n_bal +
              q_n_blm * h_n_blm +
              q_n_sma * h_n_sma +
              q_n_cat * h_n_cat +
              q_n_mor * h_n_mor +
              q_n_bra * h_n_bra +
              q_n_pbb * h_n_pbb +
              q_n_sup * h_n_sup);
              
  cout_t = cout_t*(100-PApplet.parseInt(cp5.get(Textfield.class,"tf_red_t").getText()))/100;
  cout_n = cout_n*(100-PApplet.parseInt(cp5.get(Textfield.class,"tf_red_n").getText()))/100;
  println("cout_total : " + str(cout_t+cout_n));
}
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//General functions
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//-------------------------------------------------------------------------------------------------------------------
//Initialization function
//-------------------------------------------------------------------------------------------------------------------

public void init_function()
{
  background(color(100));
  tint(255, 50+(millis()-timer)/10);
  image(img_ikaprojekt, 0, 0, width, height);
  noFill();
  strokeWeight(10);
  stroke(COLOR_IKA);
  rect(0,0,width,height);

  if (millis()-timer > 2500)
  {
    flag_first_draw = true;
    frame.setSize(1440, 810);
    background(COLOR_IKA);
    graphic();
    windowX = displayWidth/2-1440/2;
    windowY = displayHeight/2-810/2;
  }
}


//-------------------------------------------------------------------------------------------------------------------
//Timer function
//-------------------------------------------------------------------------------------------------------------------

public boolean wait(float timed)
{
  if (millis() > timer + timed) flag_wait = true;
  else flag_wait = false;
  return flag_wait;
}


//-------------------------------------------------------------------------------------
//Elapsed time function
//-------------------------------------------------------------------------------------

public int elapsed_time (int timed)
{
  return millis() - timed;
}


//-------------------------------------------------------------------------------------
//Lines draw function
//-------------------------------------------------------------------------------------

public void lines()
{
  stroke(200);
  fill(COLOR_IKA0);
  rect(0,65,420,height-65);
  noFill();
  rect(0,25,width-1,height-26);
  line(1414,0,1414,25);
  line(153,5,153,20);
  line(307,5,307,20);
  line(461,5,461,20);
  line(0,65,width,65);
  line(420,65,420,height);
  line(1388,0,1388,25);
  
  line(145,30,145,60);
  line(275,30,275,60);
  line(405,30,405,60);
  line(535,30,535,60);
  //line(665,30,665,60);
}


//-------------------------------------------------------------------------------------
//Time & Date functions
//-------------------------------------------------------------------------------------

public String time()
{
  if(second()<10 && minute()<10)
    time = hour() + ":0" + minute() + ":0" + second();
  else if(second()<10 && minute()>10)
    time = hour() + ":" + minute() + ":0" + second();
  else if(second()>10 && minute()<10)
    time = hour() + ":0" + minute() + ":" + second();
  else if(second()>10 && minute()>10)
    time = hour() + ":" + minute() + ":" + second();
    
  return time;
}

public String date()
{
  if(month()<10)
    date = day() + "/0" + month() + "/" + year();
  else
    date = day() + "/" + month() + "/" + year();
  
  return date;
}


//-------------------------------------------------------------------------------------------------------------------
//Function called when a key is pressed
//-------------------------------------------------------------------------------------------------------------------

public void keyPressed()
{
  if (key == CODED)
  {
    if (keyCode == KeyEvent.VK_F1/*key == 'S' || key =='s'*/)
    {
      cp5.getTab("default").setActive(true);
      cp5.getTab("ter").setActive(false);
      cp5.getTab("nav").setActive(false);
    } else if (keyCode == KeyEvent.VK_F2/*key == 'C' || key == 'c'*/)
    {
      cp5.getTab("default").setActive(false);
      cp5.getTab("ter").setActive(true);
      cp5.getTab("nav").setActive(false);
    } else if (keyCode == KeyEvent.VK_F3/*key == 'L' || key == 'l'*/)
    {
      cp5.getTab("default").setActive(false);
      cp5.getTab("ter").setActive(false);
      cp5.getTab("nav").setActive(true);
    }
//    else if (keyCode == RIGHT)
//    {
//      if (cp5.getTab("default").isActive())
//      {
//        cp5.getTab("default").setActive(false);
//        cp5.getTab("config").setActive(true);
//        cp5.getTab("layers").setActive(false);
//      } else if (cp5.getTab("config").isActive())
//      {
//        cp5.getTab("default").setActive(false);
//        cp5.getTab("config").setActive(false);
//        cp5.getTab("layers").setActive(true);
//      } else if (cp5.getTab("layers").isActive())
//      {
//        cp5.getTab("default").setActive(true);
//        cp5.getTab("config").setActive(false);
//        cp5.getTab("layers").setActive(false);
//      }
//    }
//    else if (keyCode == LEFT)
//    {
//      if (cp5.getTab("default").isActive())
//      {
//        cp5.getTab("default").setActive(false);
//        cp5.getTab("config").setActive(false);
//        cp5.getTab("layers").setActive(true);
//      } else if (cp5.getTab("config").isActive())
//      {
//        cp5.getTab("default").setActive(true);
//        cp5.getTab("config").setActive(false);
//        cp5.getTab("layers").setActive(false);
//      } else if (cp5.getTab("layers").isActive())
//      {
//        cp5.getTab("default").setActive(false);
//        cp5.getTab("config").setActive(true);
//        cp5.getTab("layers").setActive(false);
//      }
//    }
  }
}


//-------------------------------------------------------------------------------------------------------------------
//Function to set the window position
//-------------------------------------------------------------------------------------------------------------------

int windowX, windowY;
int i=0,j=0;
int mousePosX, mousePosY;
double oriX=0, oriY=0;

public void window_position()
{
  if(cp5.getController("moveWindow").isMousePressed())
  {
    oriX = windowX;
    oriY = windowY;
    if(!flag_window)
    {
      oriX = MouseInfo.getPointerInfo().getLocation().getX();
      oriY = MouseInfo.getPointerInfo().getLocation().getY();
      flag_window = true;     
      mousePosX = mouseX;
      mousePosY = mouseY;
    }
    else if (flag_window)
    {
      i = (int)(MouseInfo.getPointerInfo().getLocation().getX()-oriX);
      j = (int)(MouseInfo.getPointerInfo().getLocation().getY()-oriY);
      windowX+=i-mousePosX;
      windowY+=j-mousePosY;
    }

  }
  else if(!cp5.getController("moveWindow").isMousePressed())
  {
    flag_window = false;
  }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Graphic class file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class mButton
{
  mButton(String buttonName, String buttonLabel, int buttonX, int buttonY, int buttonW, int buttonH, int buttonColor, String tab)
  {
    cp5.addButton(buttonName)
      .setCaptionLabel(buttonLabel)
        .setPosition(buttonX, buttonY)
          .setSize(buttonW, buttonH)
            .setColorBackground(buttonColor)
              .setColorCaptionLabel(color(50))
                .moveTo(tab)
                  .getCaptionLabel().align(CENTER, CENTER).setFont(createFont("Calibri", 14));
  }
}

public class mTextfield
{
  mTextfield(String textName, String textLabel, int textX, int textY, int textW, int textH, String tab)
  {
    cp5.addTextfield(textName)
      .setPosition(textX, textY)
        .setSize(textW, textH)
          .setColorCaptionLabel(color(0))
            .setFont(createFont("Calibri", 14))
              .setLabel("")
                .setColorBackground(COLOR_IKA)
                  .setColor(0)
                    .setColorCursor(color(100))
                      .moveTo(tab)
                        .getCaptionLabel().setFont(createFont("Calibri",14));
  }
}

public class mTextarea
{
  mTextarea(String textName, String text, int textX, int textY, int textW, int textH, String tab)
  {
    cp5.addTextarea(textName)
      .setSize(textW,textH)
        .setPosition(textX,textY)
          .setColor(0)
            .setColorBackground(COLOR_IKA0)
              .setText(text)
                .setFont(createFont("Calibri",14))
                  .moveTo(tab);
  }
}

public void update(String buttonName)
{
  if (cp5.getController(buttonName).isInside())
    cp5.getController(buttonName).setColorCaptionLabel(color(255));
  else cp5.getController(buttonName).setColorCaptionLabel(color(50));
}

public void graphicUpdate()
{
  update("Load_config");
  update("Generate_config");
  update("Save_config");
  update("SaveAs_config");
 
  cp5.getController("Exit").setColorForeground(color(200,100,100));
  cp5.getController("Exit").setColorActive(color(200,100,100));
  
  if (cp5.getTab("default").isMouseOver() || cp5.getTab("default").isActive())
    cp5.getTab("default").getCaptionLabel().setColor(color(255));
  else cp5.getTab("default").getCaptionLabel().setColor(color(50));
  
  if (cp5.getTab("nav").isMouseOver() || cp5.getTab("nav").isActive())
    cp5.getTab("nav").getCaptionLabel().setColor(color(255));
  else cp5.getTab("nav").getCaptionLabel().setColor(color(50));

  if (cp5.getTab("ter").isMouseOver() || cp5.getTab("ter").isActive())
    cp5.getTab("ter").getCaptionLabel().setColor(color(255));
  else cp5.getTab("ter").getCaptionLabel().setColor(color(50));
}
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
  mButton Generate_config = new mButton("Generate_config", "G\u00e9n\u00e9rer config", 150, 30, 120, 30, COLOR_BUTTON, "global");
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
  q_t_gav = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_gav").getText());
  q_t_pha = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_pha").getText());
  q_t_epe = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_epe").getText());
  q_t_lan = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_lan").getText());
  q_t_tir = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_tir").getText());
  q_t_arc = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_arc").getText());
  q_t_lpi = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_lpi").getText());
  q_t_bel = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_bel").getText());
  q_t_cat = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_cat").getText());
  q_t_mor = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_mor").getText());
  q_t_gyr = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_gyr").getText());
  q_t_bbm = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_bbm").getText());
  q_t_med = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_med").getText());
  q_t_cui = PApplet.parseInt(cp5.get(Textfield.class,"tf_t_cui").getText());
  
  q_n_bav = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_bav").getText());
  q_n_lfl = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_lfl").getText());
  q_n_bel = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_bel").getText());
  q_n_bal = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_bal").getText());
  q_n_sma = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_sma").getText());
  q_n_blm = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_blm").getText());
  q_n_pbb = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_pbb").getText());
  q_n_bra = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_bra").getText());
  q_n_cat = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_cat").getText());
  q_n_mor = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_mor").getText());
  q_n_sup = PApplet.parseInt(cp5.get(Textfield.class,"tf_n_sup").getText());
  
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
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "IkaProjekt" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
