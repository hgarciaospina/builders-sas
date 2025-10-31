import { Component, inject, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';

export interface NavTab {
  title: string;
  path: string;
}

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [NgbNavModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {
  @Input() tabs: NavTab[] = [];
  router = inject(Router);

  isActive(path: string): boolean {
    return this.router.url === path;
  }

  navigate(path: string) {
    this.router.navigateByUrl(path);
  }
}
