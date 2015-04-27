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
  
  b_total = int(q_t_gav * b_t_gav +
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
  
  s_total = int(q_t_gav * s_t_gav +
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
  
  v_total = int(q_t_cui * v_t_cui);
  println("v_total : " + v_total);
  
  c_total = int(q_t_med * c_t_med +
            q_n_sma * c_n_sma +
            q_n_sup * c_n_sup);
  println("c_total : " + c_total);
  
  pop_total = int(q_t_gav * pop_t_gav +
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
  
  capa_t_total = int(q_t_gav * capa_t_gav +
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
  
  cout_t = int(q_t_gav * h_t_gav +
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
              
  cout_n = int(q_n_lfl * h_n_lfl +
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
              
  cout_t = cout_t*(100-int(cp5.get(Textfield.class,"tf_red_t").getText()))/100;
  cout_n = cout_n*(100-int(cp5.get(Textfield.class,"tf_red_n").getText()))/100;
  println("cout_total : " + str(cout_t+cout_n));
}
