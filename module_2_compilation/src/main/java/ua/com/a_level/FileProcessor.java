package ua.com.a_level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {
    private static final Path fileInput = Paths.get("input.txt");
    private static final Path inputTemplate = Paths.get("template.txt");
    private static final Path fileOutput = Paths.get("output.txt");

    public void inputFileChanger(String select) throws IOException {
        if (select.equals("1")) {
            FileWriter writer = new FileWriter(fileOutput.toFile(), false);
            writer.write("");
            fileParser(inputTemplate);
        } else if (select.equals("2")) {
            FileWriter writer = new FileWriter(fileOutput.toFile(), false);
            writer.write("");
            fileParser(fileInput);
        }
    }

    public void fileParser(Path path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            int size = Integer.parseInt(reader.readLine());
            Graphs graph = new Graphs(size);
            for (int i = 0; i < size; i++) {
                String nameEvaluations = reader.readLine();
                graph.addNode(i, nameEvaluations);
                int countConnects = Integer.parseInt(reader.readLine());
                for (int j = 0; j < countConnects; j++) {
                    String[] connect_cost = reader.readLine().split(" ");
                    graph.addWay(i, Integer.parseInt(connect_cost[0]) - 1, Integer.parseInt(connect_cost[1]));
                }
            }
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                String[] direction = reader.readLine().split(" ");
                int value = Graphs.cheapestWay(graph.cityIndex(direction[0]), graph.getEvaluations())
                        [graph.cityIndex(direction[1])];
                result(direction[0], direction[1], value);
            }
        } catch (Exception e) {
            System.out.println("Incorrect file!");
        }
    }

    private void result(String from, String to, int cost) throws IOException {
        String output = (from + " " + to + '\n' + cost + '\n');
        FileWriter writer = new FileWriter(FileProcessor.fileOutput.toFile(), true);
        writer.write(output);
        writer.flush();
        System.out.println(output);
    }
}
