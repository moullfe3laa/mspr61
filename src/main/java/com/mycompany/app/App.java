package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App
{
    public App() {}

    public static void main(String[] args) {
        BufferedReader br = null;
        ArrayList<String> staffList = new ArrayList<String>();
        String filePath = new File("").getAbsolutePath();
        File staff = new File(filePath.concat("/src/main/files/staff.txt"));
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(staff)));
            while (br.ready()) {
                // Lit une chaîne de caractère : une ligne du fichier
                String line = br.readLine();
                staffList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé, le chemin saisi est-il correct ? " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO : gérer le cas du br.ready() et du br.readline()
            System.out.println("Problème pour lire le chemin saisi" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        String indexOutput = """
                            <!DOCTYPE html>
                            <html lang="en">
                            <head>
                                <meta charset="UTF-8">
                                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                <title>Accueil</title>
                            </head>
                            """;
        indexOutput += """
                            <body>
                                <ul>
                           """;
        Collections.sort(staffList);
        for(String agent : staffList) {
            indexOutput += "\n<li><a href=\"" + agent + ".html\">" + agent + "</a></li>\n";
        }
        indexOutput += """
                        </ul>
                    </body>
                    </html>
                     """;

        PrintWriter indexWriter = null;
        try {
            indexWriter = new PrintWriter("index.html");
            indexWriter.write(indexOutput);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            indexWriter.flush();
            indexWriter.close();
        }

        Collections.sort(staffList);
        for(String agent : staffList) {
            String agentOutput = """
                    <!DOCTYPE html>
                           <html lang="en">
                           <head>
                               <meta charset="UTF-8">
                               <meta http-equiv="X-UA-Compatible" content="IE=edge">
                               <meta name="viewport" content="width=device-width, initial-scale=1.0">
                               <title>Fiche agent</title>
                               <style>
                                   @font-face {
                                       font-family: "myFont";
                                       src: url("C:\\Users\\maxju\\IdeaProjects\\mspr61\\src\\main\\font\\Roboto-Light.ttf");
                                   }
                                   ul { list-style:none; }
                                   body { font-family: "myFont"; }
                               </style>
                           </head>
                    """;
            agentOutput += """
                         <body>
                             <ul>
                                 <a href="index.html">Accueil</a>
                        """;
            agentOutput += "<h1>" + agent + "</h1>\n";
            agentOutput += "<img src=\"src/main/images/" + agent +".jpg\">\n";
            agentOutput += "</ul>\n";
            agentOutput += "<ul>\n";

            try {
                ArrayList<String> agentArray = new ArrayList<>();
                File agentList = new File(filePath.concat("/src/main/files/" + agent + ".txt"));
                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(agentList)));
                while (br2.ready()) {
                    agentArray.add(br2.readLine());
                }
                br2.close();
                File list = new File(filePath.concat("/src/main/files/liste.txt"));
                br = new BufferedReader(new InputStreamReader(new FileInputStream(list)));
                while (br.ready()) {
                    // Lit une chaîne de caractère : une ligne du fichier
                    String line = br.readLine();
                    String[] str = line.split("\t| ", 2);
                    for (String agentLine : agentArray) {
                        if (agentLine.equals(str[0])) {
                            agentOutput += "<li><input type=\"checkbox\" checked disabled>" + str[1] + "</li>";
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Le fichier n\'a pas été trouvé, le chemin saisi est-il correct ? " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                // TODO : gérer le cas du br.ready() et du br.readline()
                System.out.println("Problème pour lire le chemin saisi" + e.getMessage());
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            agentOutput += """
                            </ul>
                        </body>
                        </html>
                        """;

            PrintWriter agentWriter = null;
            try {
                agentWriter = new PrintWriter(agent + ".html");
                agentWriter.write(agentOutput);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                agentWriter.flush();
                agentWriter.close();
            }
        }
    }
}
