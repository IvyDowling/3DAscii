package ascii3d;

import asciiPanel.Render;
import java.awt.Color;

public class ImageLib {

    private static final char H_BAR = '\u00C4';
    private static final char V_BAR = '\u00B3';
    private static final char DOUBLE_V_BAR = '\u00BA';
    private static final char DOUBLE_H_BAR = '\u00CD';
    private static final char B_L_CORNER = '\u00C0';
    private static final char T_L_CORNER = '\u00DA';
    private static final char B_R_CORNER = '\u00D9';
    private static final char T_R_CORNER = '\u00BF';
    private static final char B_L_DOUBLE_CORNER = '\u00C8';
    private static final char T_L_DOUBLE_CORNER = '\u00C9';
    private static final char B_R_DOUBLE_CORNER = '\u00BC';
    private static final char T_R_DOUBLE_CORNER = '\u00BB';

    private static final String[] hallSample = {
        "\\                                                                              / ",
        "  \\                                                                          /",
        "    \\                                                                      /",
        "      \\                                                                  /",
        "        \\                                                              /",
        "          \\                                                          /",
        "            \\                                                      /",
        "              \\                                                  /",
        "                \\                                              /",
        "                  \\                                          /",
        "                    \\                                      /",
        "                      \\                                  /",
        "                        \\                              /",
        "                          \\                          /",
        "                            \\                      /",
        "                              \\                  /",
        "                                \\              /",
        "                                  \\          /",
        "                                    \\      /",
        "                                      \\  /",
        "                                       []",
        "                                      /  \\",
        "                                    /      \\",
        "                                  /          \\",
        "                                /              \\",
        "                              /                  \\",
        "                            /                      \\",
        "                          /                          \\",
        "                        /                              \\",
        "                      /                                  \\",
        "                    /                                      \\",
        "                  /                                          \\",
        "                /                                              \\",
        "              /                                                  \\",
        "            /                                                      \\",
        "          /                                                          \\",
        "        /                                                              \\",
        "      /                                                                  \\",
        "    /                                                                      \\",
        "  /                                                                          \\",
        "/                                                                              \\"};

    private static final int SCREEN_WIDTH = hallSample[0].length();
    private static final int SCREEN_HEIGHT = hallSample.length;

    private static Render[] toRenderArray(String[] s, Color fg, Color bg) {
        Render[] temp = new Render[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = new Render(s[i], 0, i, fg, bg);
        }
        return temp;
    }

    private static Render[] toRenderArray(String[] s, int x, int y, Color fg, Color bg) {
        Render[] temp = new Render[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = new Render(s[i], x, y + i, fg, bg);
        }
        return temp;
    }

    public static Render[] getHallSample(Color fg, Color bg) {
        return toRenderArray(hallSample, fg, bg);
    }

    public static Render[] getWall(int width, Color fg, Color bg) {
        Render[] temp = new Render[width];
        //find out where we need to start the Renders for this wall
        int xStart = (SCREEN_WIDTH / 2 - width / 2) - 4;
        int yStart = (SCREEN_HEIGHT / 2 - width / 2);
        //build the top line
        String line = T_L_CORNER + "";
        for (int c = 0; c < (width * 2) - 4; c++) {
            line += H_BAR;
        }
        line += T_R_CORNER;
        temp[0] = new Render(line, xStart, yStart++, fg, bg);
        //All the v lines: start at 1, end at length-1
        for (int i = 1; i < (temp.length - 1); i++) {
            String s = V_BAR + "";
            for (int w = 0; w < (width - 2) * 2; w++) {
                s += " ";
            }
            s += V_BAR;
            temp[i] = new Render(s, xStart, yStart++, fg, bg);
        }
        //reuse the top line
        line = B_L_CORNER + line.substring(1, line.length() - 1);
        line += B_R_CORNER;
        temp[temp.length - 1] = new Render(line, xStart, yStart++, fg, bg);
        return temp;
    }
}
