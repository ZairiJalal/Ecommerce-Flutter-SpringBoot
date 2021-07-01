import 'package:flutter/material.dart';
import 'package:flutter_rest_api/rest_api.dart';
import 'dart:io';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.purple,
      ),
      home: NewPage(),
    );
  }
}

class NewPage extends StatefulWidget {
  @override
  _NewPageState createState() => _NewPageState();
}

class _NewPageState extends State<NewPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter NEWS'),
      ),
      body: FutureBuilder(
        future: ApiService.getNews(),
        builder: (context, snapshot) {
          final news = snapshot.data;
          if (snapshot.connectionState == ConnectionState.done) {
            return ListView.separated(
              separatorBuilder: (context, index) {
                return Divider(
                  height: 2,
                  color: Colors.black,
                );
              },
              itemBuilder: (context, index) {
                 return Card(
    elevation: 2.0,
    margin: EdgeInsets.only(bottom: 20.0),
    child: Padding(
      padding: EdgeInsets.all(8.0),
      child: Row(
        children: [
          Hero(
            tag: '${news[index]['_id']}',
            child: Container(
              width: 80,
              height: 80.0,
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: NetworkImage('${news[index]['imageUrl']}'),
                  fit: BoxFit.cover,
                ),
                borderRadius: BorderRadius.circular(8.0),
              ),
            ),
          ),
          SizedBox(width: 5.0),
          Expanded(
              child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                '${news[index]['title']}',
                style: TextStyle(
                  fontSize: 18.0,
                ),
              ),
              SizedBox(
                height: 5.0,
              ),
              Row(
                children: [
                  FlatButton(
                          onPressed: () {
                            ApiService.deleteNew(news[index]['_id']).then((_) {
                              setState(() {
                              });
                            });
                          },
                          child: Icon(
                            Icons.delete,
                            color: Colors.red,
                          ),
                        ),
                        FlatButton(
                          onPressed: () {
                          },
                          child: Icon(
                            Icons.edit,
                            color: Colors.blue,
                          ),
                        ),
                  SizedBox(
                    width: 10,
                  ),
                  Icon(Icons.date_range),
                  Text(
                    '${news[index]['date']}',
                    style: TextStyle(
                      fontSize: 12.0,
                    ),
                  ),
                ],
              )
            ],
          ))
        ],
      ),
    ),
  );
              },
              itemCount: news.length,
            );
          }
          return Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push( context,
          MaterialPageRoute(
              builder: (context) => AddNewPage(),
            ),
          );
        },
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }
}

class AddNewPage extends StatefulWidget {
  AddNewPage({Key key}) : super(key: key);

  _AddNewPageState createState() => _AddNewPageState();
}

class _AddNewPageState extends State<AddNewPage> {

  final _titleController = TextEditingController();
  final _descreptionController = TextEditingController();
  final _authorController = TextEditingController();
  File file;
  String dropdownValue = 'Sport';


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add New '),
      ),
      body: Center(
        child: Padding(
          padding: EdgeInsets.all(10),
          child: Column(
            children: <Widget>[
              TextField(
                controller: _titleController,
                decoration: InputDecoration(hintText: 'Title'),
              ),
              TextField(
                controller: _descreptionController,
                decoration: InputDecoration(hintText: 'Descreption'),
              ),
               TextField(
                controller: _authorController,
                decoration: InputDecoration(hintText: 'Author'),
              ),
              DropdownButton<String>(
                 value: dropdownValue,
                 icon: const Icon(Icons.arrow_downward),
                 iconSize: 24,
                 elevation: 16,
                 style: const TextStyle(color: Colors.deepPurple),
                 underline: Container(
                   height: 2,
                   color: Colors.deepPurpleAccent,
                 ),
                 onChanged: (String newValue) {
                   setState(() {
                     dropdownValue = newValue;
                   });
                 },
                 items: <String>['Sport', 'Education', 'Covid ', 'Politique']
                      .map<DropdownMenuItem<String>>((String value) {
                          return DropdownMenuItem<String>(
                                value: value,
                                child: Text(value),
                          );
                      }).toList(),
              ),
              
              RaisedButton(
                    child: Text("Image"),
                    onPressed: () async {
                      
                    },
                    
                  ),

              RaisedButton(
                child: Text(
                  'SAVE',
                  style: TextStyle(
                    color: Colors.white,
                  ),
                ),
                color: Colors.purple,
                onPressed: () {
                  var body = new Map<String, dynamic>();
                  body['title'] = _titleController.text;
                  body['description'] = _descreptionController.text;
                  body['categorie'] = dropdownValue;
                  body['author'] = _authorController.text;
                  ApiService.addNew(body).then((success) {
                    if (success) {
                      showDialog(
                        builder: (context) => AlertDialog(
                          title: Text('New has been added!!!'),
                          actions: <Widget>[
                            FlatButton(
                              onPressed: () {
                                Navigator.pop(context);
                                _titleController.text = '';
                                _descreptionController.text = '';
                                _authorController.text = '';
                              },
                              child: Text('OK'),
                            )
                          ],
                        ),
                        context: context,
                      );
                      return;
                    }else{
                      showDialog(
                        builder: (context) => AlertDialog(
                          title: Text('Error Adding New!!!'),
                          actions: <Widget>[
                            FlatButton(
                              onPressed: () {
                                Navigator.pop(context);
                              },
                              child: Text('OK'),
                            )
                          ],
                        ),
                        context: context,
                      );
                      return;
                    }
                  });
                },
              )
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => NewPage(),
            ),
          );
        },
        tooltip: 'Increment',
        child: Icon(Icons.remove_circle),
      ),
    );
  }
}
