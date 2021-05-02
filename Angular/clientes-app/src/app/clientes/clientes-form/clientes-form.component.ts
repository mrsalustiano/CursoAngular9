import { Observable } from 'rxjs';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Cliente } from './../cliente';
import { ClientesService } from '../../clientes.service'
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  errors: string[];
  id: number = null;

  constructor(
    private service: ClientesService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {
    this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activeRoute.params;
    params.subscribe(urlParams => {
      this.id = urlParams['id'];
      if (this.id) {
        this.service
          .getClienteById(this.id)
          .subscribe(
            response => this.cliente = response,
            errorResponse => this.cliente = new Cliente()
          )
      }

    })

  }

  onSubmit() {
    if (this.id) {

      this.service.atualizar(this.cliente)
        .subscribe(response => {
          this.success = true;
          this.errors = null;
        }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;

        }

        )

    } else {
      this.service
        .salvar(this.cliente)
        .subscribe(response => {
          this.success = true;
          this.errors = null;
          this.cliente = response;
        }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        }
        );
    }

  }

  voltarLista() {
    this.router.navigate(['/clientes-lista']);

  }

}
