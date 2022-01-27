package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App
{
    public App() {}

    public static void main(String[] args) {
        String password = "";
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
                         <style>
                            @font-face {
                                font-family: "light";
                                src: url("src/main/font/Roboto-Light.ttf");
                            }
                            @font-face {
                                font-family: "medium";
                                src: url("src/main/font/Roboto-Medium.ttf");
                            }
                            body { font-family: "light"; }
                            ul { list-style:none; }
                            li { margin : 1em; display : flex; flex-direction: column; justify-content : center; }
                            span { display : flex; flex-direction: row; justify-content : center; margin-bottom: 2em; }
                            a { text-decoration:none; color: #000000; margin: 0 auto; width: 15%; }
                            button { 
                                width: 100%; 
                                align-self : center; 
                                border: none;
                                font-family: "medium";
                                border-radius : 2em;
                                display: block;
                                text-align: center;
                                cursor: pointer;
                                text-transform: uppercase;
                                outline: none;
                                overflow: hidden;
                                font-weight: 600;
                                font-size: 15px;
                                background-color: #379EC1;
                                margin: 0 auto;
                                padding: 1em 2em;
                            }
                            button:hover {
                                color: white;
                                background-color: #659224;
                            }
                        </style>
                     </head>
                     """;
        indexOutput += """
                            <body>
                                <span>
                                    <img src="src/main/images/logo.PNG">
                                </span>
                                <ul>
                           """;
        Collections.sort(staffList);
        for(String agent : staffList) {
            indexOutput += "\n<li><a href=\"" + agent + ".html\"><button type=\"button\">" + agent + "</button></a></li>\n";
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
                                       font-family: "light";
                                       src: url("src/main/font/Roboto-Light.ttf");
                                   }
                                   @font-face {
                                       font-family: "medium";
                                       src: url("src/main/font/Roboto-Medium.ttf");
                                   }
                                   body { font-family: "light"; padding-left: 2em; padding-right: 2em; }
                                   h1 { font-family: "medium"; color: #379EC1; border: 0.3em solid #659224; padding : 0.5em; }
                                   ul { list-style:none; padding-left: 0; }
                                   li { color : #000000; }
                                   span { display : flex; flex-direction: row; justify-content : center; margin-bottom: 2em; }
                                   #row { display : flex; flex-direction: row; justify-content : space-around; }
                                   #column { display : flex; flex-direction: column; }
                                   #idCard { display: block; }
                                   img { border-radius : 2em; }
                               </style>
                           </head>
                    """;
            agentOutput += """
                         <body>
                             <span>
                                 <a href="index.html"><img title="Accueil" src="src/main/images/logo.PNG"></a>
                             </span>
                        """;


            try {
                ArrayList<String> agentArray = new ArrayList<>();
                File agentList = new File(filePath.concat("/src/main/files/" + agent + ".txt"));
                BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(agentList)));
                while (br2.ready()) {
                    agentArray.add(br2.readLine());
                }
                agentOutput += "<div id =\"row\"><div id =\"column\"><h1>" + agentArray.get(1) + " " + agentArray.get(0) + "</h1>\n";
                agentOutput += "<ul>\n";
                br2.close();
                File list = new File(filePath.concat("/src/main/files/liste.txt"));
                br = new BufferedReader(new InputStreamReader(new FileInputStream(list)));
                while (br.ready()) {
                    // Lit une chaîne de caractère : une ligne du fichier
                    String line = br.readLine();
                    String[] str = line.split("\t| ", 2);
                    for (String agentLine : agentArray) {
                        if (agentLine.equals(str[0])) {
                            agentOutput += "<li><input type=\"checkbox\" checked disabled>" + str[1].trim() + "</li>";
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
                            </ul></div>
                            """;
            agentOutput += "<img id=\"idCard\" src=\"src/main/images/" + agent + ".jpg\"></div>\n";
            agentOutput += """
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
