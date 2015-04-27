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
//AF: rectangles autour des liens quand survolés
//AF: réglage des réductions de coût selon les recherches
//AF: simulation sur différentes durées
//AF: mise à jour automatique au fur et à mesure des changements
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//-------------------------------------------------------------------------------------------------------------------
//Importations
//-------------------------------------------------------------------------------------------------------------------

import controlP5.*            ;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo     ;
import java.awt.*             ;


//-------------------------------------------------------------------------------------------------------------------
//Declarations
//-------------------------------------------------------------------------------------------------------------------

final color COLOR_BCKG = color(240)  ;
final color COLOR_BUTTON = color(250,234,198);
final color COLOR_IKA = color(250,234,198);
final color COLOR_IKA0 = color(253,247,221);

final float b_t_gav = 130, s_t_gav = 180 , h_t_gav = 12, capa_t_gav = 15, pg_t_gav = 6.2 , pop_t_gav = 2;
final float b_t_pha = 40 , s_t_pha = 30  , h_t_pha = 3 , capa_t_pha = 5 , pg_t_pha = 1.4 , pop_t_pha = 1;
final float b_t_epe = 30 , s_t_epe = 30  , h_t_epe = 4 , capa_t_epe = 3 , pg_t_epe = 1.2 , pop_t_epe = 1;
final float b_t_lan = 30 , s_t_lan = 0   , h_t_lan = 1 , capa_t_lan = 3 , pg_t_lan = 0.6 , pop_t_lan = 1;
final float b_t_tir = 50 , s_t_tir = 150 , h_t_tir = 3 , capa_t_tir = 5 , pg_t_tir = 4   , pop_t_tir = 1;
final float b_t_lpi = 20 , s_t_lpi = 0   , h_t_lpi = 2 , capa_t_lpi = 3 , pg_t_lpi = 0.4 , pop_t_lpi = 1;
final float b_t_arc = 30 , s_t_arc = 25  , h_t_arc = 4 , capa_t_arc = 5 , pg_t_arc = 1.1 , pop_t_arc = 1;
final float b_t_bel = 220, s_t_bel = 0   , h_t_bel = 15, capa_t_bel = 30, pg_t_bel = 4.4 , pop_t_bel = 5;
final float b_t_cat = 260, s_t_cat = 300 , h_t_cat = 25, capa_t_cat = 30, pg_t_cat = 11.2, pop_t_cat = 5;
final float b_t_mor = 300, s_t_mor = 1250, h_t_mor = 30, capa_t_mor = 30, pg_t_mor = 31  , pop_t_mor = 5;
final float b_t_gyr = 25 , s_t_gyr = 100 , h_t_gyr = 15, capa_t_gyr = 15, pg_t_gyr = 2.5 , pop_t_gyr = 3;
final float b_t_bbm = 40 , s_t_bbm = 250 , h_t_bbm = 45, capa_t_bbm = 30, pg_t_bbm = 5.8 , pop_t_bbm = 5;
final float b_t_med = 50 , c_t_med = 450 , h_t_med = 20, capa_t_med = 10, pg_t_med = 10  , pop_t_med = 1;
final float b_t_cui = 50 , v_t_cui = 150 , h_t_cui = 10, capa_t_cui = 20, pg_t_cui = 4   , pop_t_cui = 1;

final float b_n_lfl = 80 , s_n_lfl = 230 ,                h_n_lfl = 25 , pg_n_lfl = 6.2 , pop_n_lfl = 4;
final float b_n_bav = 400, s_n_bav = 800 ,                h_n_bav = 45 , pg_n_bav = 24  , pop_n_bav = 2;
final float b_n_bel = 250, s_n_bel = 0   ,                h_n_bel = 15 , pg_n_bel = 5   , pop_n_bel = 3;
final float b_n_bal = 180, s_n_bal = 160 ,                h_n_bal = 20 , pg_n_bal = 6.8 , pop_n_bal = 6;
final float b_n_blm = 200, s_n_blm = 1200,                h_n_blm = 55 , pg_n_blm = 28  , pop_n_blm = 2;
final float b_n_sma = 160, s_n_sma = 100 , c_n_sma = 750, h_n_sma = 50 , pg_n_sma = 20.2, pop_n_sma = 3;
final float b_n_cat = 180, s_n_cat = 140 ,                h_n_cat = 35 , pg_n_cat = 6.4 , pop_n_cat = 5;
final float b_n_mor = 220, s_n_mor = 900 ,                h_n_mor = 50 , pg_n_mor = 22.4, pop_n_mor = 5;
final float b_n_bra = 40 , s_n_bra = 280 ,                h_n_bra = 5  , pg_n_bra = 6.4 , pop_n_bra = 1;
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

void setup()
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

void draw()
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
      fps = int(frameRate);
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
