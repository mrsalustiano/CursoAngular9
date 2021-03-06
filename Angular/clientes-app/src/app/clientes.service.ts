import { Cliente } from './clientes/cliente';
import { HttpClient } from '@angular/common/http'

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private http: HttpClient) { }

  salvar(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);

  }


  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  } 
  
  getClienteById(id: number): Observable<Cliente>{
    return this.http.get<Cliente>(`http://localhost:8080/api/clientes/${id}`);
  }

  atualizar(cliente: Cliente): Observable<any> {
    return this.http.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente); 

  }

  deletar(cliente: Cliente): Observable<any> {
    return this.http.delete<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`); 

  }


  
}
