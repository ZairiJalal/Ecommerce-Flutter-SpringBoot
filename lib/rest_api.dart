import 'dart:convert';

import 'package:http/http.dart' as http;

class URLS {
  static const String BASE_URL = 'https://news-appli.herokuapp.com';
}

class ApiService {
  static Future<List<dynamic>> getNews() async {
    final response = await http.get('${URLS.BASE_URL}/news');
    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      return null;
    }
  }

  static Future<bool> addNew(Map<String, dynamic> data) async {
    final response = await http.post(
      '${URLS.BASE_URL}/news',
      body: data,
    );
    if (response.statusCode == 200) {
      return true;
    } else {
      return false;
    }
  }

  static Future<bool> deleteNew(id) async {
    final response = await http.delete(
      '${URLS.BASE_URL}/news/${id}',
    );
    if (response.statusCode == 200) {
      return true;
    } else {
      return false;
    }
  }
}
      // headers: {"content-type": "application/json; charset=utf-8"},
