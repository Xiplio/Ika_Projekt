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

boolean wait(float timed)
{
  if (millis() > timer + timed) flag_wait = true;
  else flag_wait = false;
  return flag_wait;
}


//-------------------------------------------------------------------------------------
//Elapsed time function
//-------------------------------------------------------------------------------------

int elapsed_time (int timed)
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

void keyPressed()
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
