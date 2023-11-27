def updateContent(String filePath, String recordName, String weightValue){
    def contents = new File( filePath ).text.readLines()
    def newContents = new ArrayList();
    for(int i=0;i<contents.size();i++){
        newContents.add(i, contents.get(i));
        if (contents.get(i).contains(recordName)){
            for(int j = i; j>=0;j--){
                if(contents.get(j).contains("weight")){
                    String str = contents.get(j);
                    String[] weight = extractInts(str);
                    str = contents.get(j).replace(weight[0], weightValue);
                    newContents.set(j, str);
                    break;
                }
            }
        }
        
    }

    File f = new File(filePath)
    PrintWriter writer = new PrintWriter(f)
    newContents.each { id -> writer.println(id) }
    writer.close()
}


def extractInts(String input){
    input.findAll( /\d+/ )*.toInteger()
}

updateContent("./grid.tf","dev.example.com","50");
updateContent("./grid.tf","live.example.com","500");
