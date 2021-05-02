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

/*
  getCliente() : Observable<Cliente[]> {
    return null;
  } 
  */

  getClientes() : Cliente[]{
    let cliente = new Cliente();
    cliente.id = 1;
    cliente.dataCadastro = '01/05/2021';
    cliente.nome = 'Marcelo';
    cliente.cpf = '12345678901';

    return [cliente];
  }
}
