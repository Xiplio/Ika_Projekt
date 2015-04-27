/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Graphic class file
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class mButton
{
  mButton(String buttonName, String buttonLabel, int buttonX, int buttonY, int buttonW, int buttonH, color buttonColor, String tab)
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
