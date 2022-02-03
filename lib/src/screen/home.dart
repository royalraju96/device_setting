import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Device Setting'),
      ),
      body:  Center(
        child: InkWell(child: const Text("Open Device Setting"),
        onTap: (){
          if (kDebugMode) {
            print("Opening Device Setting");

          }},
        ),
      ),
    );
  }
}
